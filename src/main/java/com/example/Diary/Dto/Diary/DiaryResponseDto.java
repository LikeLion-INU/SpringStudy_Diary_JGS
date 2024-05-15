package com.example.Diary.Dto.Diary;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DiaryResponseDto {
    @Getter
    public static class writeDiary{
        private LocalDate recordDate;
        private String weather;
        private Double minTemp;
        private Double maxTemp;

    }
    @Getter
    public static class updateDiary{

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
