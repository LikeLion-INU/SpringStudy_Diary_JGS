package com.example.Diary.Service.Diary;

import com.example.Diary.Dto.Diary.DiaryRequestDto;
import com.example.Diary.Dto.Diary.DiaryResponseDto;
import com.example.Diary.common.ApiResponse;
import org.json.simple.parser.ParseException;

public interface DiaryService {
    ApiResponse<?> writeDiary(DiaryRequestDto.writeDiary dto, Long userId) throws ParseException;         // 다이어리 - 다이어리 작성 (날씨 API / 이미지 첨부)
    ApiResponse<?> updateDiary(DiaryRequestDto.updateDiary dto, Long userId);      // 다이어리 - 작성한 다이어리 수정
    ApiResponse<?> deleteDiary(DiaryRequestDto.deleteDiary dto, Long userId);      // 다이어리 - 작성한 다이어리 삭제
    ApiResponse<?> diaryList(DiaryRequestDto.diaryList dto, Long userId);            // 다이어리 - 열람가능한 다이어리 리스트 조회
    ApiResponse<?> diaryContent(DiaryRequestDto.diaryContent dto, Long userId);   // 다이어리 - 상세읽기 ( 권한 설정 - 비공개, 전체공개, 일부공개 )

    // 다이어리 - 조회수 카운트
    // 다이어리 - 좋아요 기능
}
