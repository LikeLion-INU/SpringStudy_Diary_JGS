package com.example.Diary.common;

import com.example.Diary.Entity.DiaryEntity;
import com.example.Diary.Entity.PhotoFile;
import com.example.Diary.Repository.PhotoFileRepository;
import com.example.Diary.common.exception.CustomException;
import com.example.Diary.common.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@PropertySource("classpath:/application.properties")
public class FileUploadUtils {
    @Value("${spring.locations.file-archive}")
    private String archive;
    @Autowired
    private PhotoFileRepository photoFileRepository;

    /**
     * 이미지 업로드 (저장)
     * @param diaryEntity - DiaryEntity : 이미지를 등록한 다이어리 Entity
     * @param files - MultipartFile[] : 파일 배열
     */
    public void uploadFiles(DiaryEntity diaryEntity, MultipartFile[] files) {

        // 1. uploadPath(archive)에 해당하는 디렉터리가 존재하지 않는 경우, 부모 디렉터리를 포함한 모든 디렉터리를 생성
        File dir = new File(archive);
        if (!dir.exists()) {
            boolean folderExist = dir.mkdirs();
            log.info("folderExist :: {}", folderExist);
        }

        // 2. Save할 Entity를 담을 리스트
        List<PhotoFile> fileList = new ArrayList<>();

        // 3. 파일 개수만큼 forEach
        for (MultipartFile file : files) {
            // 3-1. 이미지 파일이 아닌 경우, 등록 안함.
            if (file.getSize() < 1 || file.getContentType() == null) continue;
            String[] contentType = file.getContentType().split("/");
            if (!"image".equals(contentType[0])) continue;

            // 3-2. DB에 저장이 필요한 파일명 처리
            String origFilename = file.getOriginalFilename();   // 원본 파일명
            String extension = contentType[1];                  // 파일 확장자
            String fileUuid = getUuid() + "." + extension;      // 서버에 저장할 파일명 (날짜 + 랜덤 문자열 + 확장자) - 파일명이 동일하면 덮어쓰기가 이뤄지는 위험 방지를 위함.

            try {
                // 3-3. 업로드 경로에 fileUuid와 동일한 이름으로 파일 생성
                file.transferTo(new File(archive, fileUuid));

                // 3-4. Save 처리할 Entity 정보 저장
                fileList.add(
                        PhotoFile.builder()
                                .origFilename(origFilename)
                                .fileUuid(fileUuid)
                                .diaryEntity(diaryEntity)
                                .build());
            } catch (IllegalStateException | IOException e) {
                throw new CustomException(ErrorCode.UPLOAD_FAILED);
            }
        }

        photoFileRepository.saveAll(fileList);
    }

    /**
     * 이미지 삭제
     * @param fileSeq - Long : 삭제하려는 이미지 시퀀스 넘버
     */
    public void deleteFile(Long fileSeq) {

        // 1. 삭제 요청한 데이터가 있는지 확인
        PhotoFile fileEntity = photoFileRepository.findById(fileSeq)
                .orElseThrow(() -> new CustomException(ErrorCode.FILE_NOT_FOUND));

        // 2. 업로드된 파일 경로 획득
        String uploadedFilePath = Paths.get(archive, fileEntity.getFileUuid()).toString();

        // 3. 파일 찾기
        File file = new File(uploadedFilePath);

        // 4. 파일 및 DB 정보 삭제
        if (file.exists()) {
            boolean deleteRe = file.delete();
            // 파일이 삭제되면, DB 에서 정보 삭제
            if (deleteRe) photoFileRepository.delete(fileEntity);
        }else {
            log.debug("FILE NOT FOUND");
            log.debug("savedFilename : {}", fileEntity.getFileUuid());
            photoFileRepository.delete(fileEntity);
        }
    }

    /**
     * 이미지 조회
     * @param entity - PhotoFile : 바이트로 변환하려는 포토 entity
     */
    public byte[] viewImage(PhotoFile entity) {
        try {
            String uploadedFilePath = Paths.get(archive, entity.getFileUuid()).toString();
            return Files.readAllBytes(new File(uploadedFilePath).toPath());
        } catch (IOException e) {
            throw new CustomException(ErrorCode.FILE_NOT_FOUND);
        }
    }


    private String getUuid() {
        return (LocalDate.now()+ UUID.randomUUID().toString()).replaceAll("-", "");
    }
}
