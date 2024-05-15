package com.example.Diary.Controller.diary.dto;

import com.example.Diary.Entity.DiaryEntity;
import com.example.Diary.Entity.UsersEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class DiaryRequestDto {
    @Data
    public static class writeDiary{
        private String locationName;
        private int year;
        private int month;
        private int day;

        private int publicState;    //공개상태 (0:전체공개 1:비공개 2:일부공개)
        private String title;       //제목
        private String contents;    //내용
        private int photoYn;  //사진유무 (0:X 1:O)

        public DiaryEntity toEntity(Map<String,Object> weather){
            return DiaryEntity.builder()
                    .publicState(this.publicState)
                    .recordDate(LocalDate.of(this.year, this.month, this.day))
                    .weather((String) weather.get("weather"))
                    .title(this.title)
                    .contents(this.contents)
                    .photoYn(this.photoYn)
                    .build();
        }
    }
    @Data
    public static class updateDiary{

    }
    @Data
    public static class deleteDiary{

    }
    @Data
    public static class diaryList{

    }
    @Data
    public static class diaryContent{

    }
}
