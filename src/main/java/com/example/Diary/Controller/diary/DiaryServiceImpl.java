package com.example.Diary.Controller.diary;

import com.example.Diary.Controller.diary.dto.DiaryRequestDto;
import com.example.Diary.Controller.diary.dto.DiaryResponseDto;
import com.example.Diary.Repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService{
    private final DiaryRepository diaryRepository;

    /**
     * 다이어리 - 다이어리 작성 (날씨 API / 이미지 첨부)
     * @param dto DiaryRequestDto.writeDiary
     * @return DiaryResponseDto.writeDiary
     */
    @Override
    public DiaryResponseDto.writeDiary writeDiary(DiaryRequestDto.writeDiary dto) {
        // 1. 전달받은 날짜를 가지고 날씨 API에서 데이터 가져오기

        // 2. 데이터 저장

        return null;
    }

    /**
     * 다이어리 - 작성한 다이어리 수정
     * @param dto DiaryRequestDto.updateDiary
     * @return DiaryResponseDto.updateDiary
     */
    @Override
    public DiaryResponseDto.updateDiary updateDiary(DiaryRequestDto.updateDiary dto) {
        // 1. 구분자 값으로 데이터 존재 여부 확인

        // 2. 데이터가 존재하는 경우, 날짜값을 비교하여 날짜가 변경된 경우, 날씨 API에서 데이터 가져오기

        // 3. 데이터 수정
        return null;
    }

    /**
     * 다이어리 - 작성한 다이어리 삭제
     * @param dto DiaryRequestDto.deleteDiary
     * @return DiaryResponseDto.deleteDiary
     */
    @Override
    public DiaryResponseDto.deleteDiary deleteDiary(DiaryRequestDto.deleteDiary dto) {
        // 1. 데이터 존재 여부 확인

        // 2. 존재하는 경우, 삭제
        return null;
    }

    /**
     * 다이어리 - 열람가능한 다이어리 리스트 조회
     * @param dto DiaryRequestDto.diaryList
     * @return DiaryResponseDto.diaryList
     */
    @Override
    public DiaryResponseDto.diaryList diaryList(DiaryRequestDto.diaryList dto) {
        // 1. 사용자가 팔로우한 목록 확인

        // 2. 본인 및 팔로우한 사람이 작성한 사람에 해당하는 데이터 가져오기

        // 3. entity 데이터 dto 로 전환
        return null;
    }

    /**
     * 다이어리 - 상세읽기 ( 권한 설정 - 비공개, 전체공개, 일부공개 )
     * @param dto DiaryRequestDto.diaryContent
     * @return DiaryResponseDto.diaryContent
     */
    @Override
    public DiaryResponseDto.diaryContent diaryContent(DiaryRequestDto.diaryContent dto) {
        // 1. 조회 요청한 다이어리 정보 가져오기

        // 2. 사용자가 팔로우한 사용자인지 확인

        // 3. 2에서 접근 권한이 있는 경우, 데이터 전달

        return null;
    }
}
