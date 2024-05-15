package com.example.Diary.Dto.Diary;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

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
    public static class deleteDiary{

    }
    @Getter
    public static class diaryList{

    }
    @Getter
    public static class diaryContent{

    }
}
