package com.example.Diary.Controller.diary;

import com.example.Diary.Controller.diary.dto.DiaryRequestDto;
import com.example.Diary.Controller.diary.dto.DiaryResponseDto;

public interface DiaryService {
    DiaryResponseDto.writeDiary writeDiary(DiaryRequestDto.writeDiary dto);         // 다이어리 - 다이어리 작성 (날씨 API / 이미지 첨부)
    DiaryResponseDto.updateDiary updateDiary(DiaryRequestDto.updateDiary dto);      // 다이어리 - 작성한 다이어리 수정
    DiaryResponseDto.diaryList diaryList(DiaryRequestDto.diaryList dto);            // 다이어리 - 열람가능한 다이어리 리스트 조회
    DiaryResponseDto.diaryContent diaryContent(DiaryRequestDto.diaryContent dto);   // 다이어리 - 상세읽기 ( 권한 설정 - 비공개, 전체공개, 일부공개 )

    // 다이어리 - 조회수 카운트
    // 다이어리 - 좋아요 기능
}
