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
        return null;
    }

    /**
     * 다이어리 - 작성한 다이어리 수정
     * @param dto DiaryRequestDto.updateDiary
     * @return DiaryResponseDto.updateDiary
     */
    @Override
    public DiaryResponseDto.updateDiary updateDiary(DiaryRequestDto.updateDiary dto) {
        return null;
    }

    /**
     * 다이어리 - 열람가능한 다이어리 리스트 조회
     * @param dto DiaryRequestDto.diaryList
     * @return DiaryResponseDto.diaryList
     */
    @Override
    public DiaryResponseDto.diaryList diaryList(DiaryRequestDto.diaryList dto) {
        return null;
    }

    /**
     * 다이어리 - 상세읽기 ( 권한 설정 - 비공개, 전체공개, 일부공개 )
     * @param dto DiaryRequestDto.diaryContent
     * @return DiaryResponseDto.diaryContent
     */
    @Override
    public DiaryResponseDto.diaryContent diaryContent(DiaryRequestDto.diaryContent dto) {
        return null;
    }
}
