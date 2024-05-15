package com.example.Diary.Dto.Diary;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class DiaryResponseDto {
    @Getter
    @Builder
    public static class writeDiary{
        private Long diaryId;
        private LocalDate recordDate;
        private String weather;
        private Double tempMin;
        private Double tempMax;

    }
    @Getter
    @Builder
    public static class updateDiary{
        private Long diaryId;
        private LocalDate recordDate;
        private String weather;
        private Double tempMin;
        private Double tempMax;
    }
    @Getter
    @Builder
    public static class canViewDiaryList{
        private List<DiaryDto> diaryList;

    }
    @Getter
    public static class diaryContent{

    }
}
