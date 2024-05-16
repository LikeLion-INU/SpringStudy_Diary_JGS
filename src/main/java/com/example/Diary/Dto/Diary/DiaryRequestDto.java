package com.example.Diary.Dto.Diary;

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

        public DiaryEntity toEntity(Map<String,Object> weather, UsersEntity users){
            return DiaryEntity.builder()
                    .publicState(this.publicState)
                    .recordDate(LocalDate.of(this.year, this.month, this.day))
                    .weather((String) weather.get("weather"))
                    .tempMin((Double) weather.get("tempMin"))
                    .tempMax((Double) weather.get("tempMax"))
                    .title(this.title)
                    .contents(this.contents)
                    .photoYn(this.photoYn)
                    .users(users)
                    .build();
        }
    }
    @Data
    public static class updateDiary{
        private Long diaryId;
        private String locationName;
        private int year;
        private int month;
        private int day;

        private int publicState;    //공개상태 (0:전체공개 1:비공개 2:일부공개)
        private String title;       //제목
        private String contents;    //내용
        private int photoYn;        //사진유무 (0:X 1:O)

    }
    @Data
    public static class deleteDiary{
        private Long diaryId;
    }
    @Data
    public static class diaryContent{
        private Long diaryId;
    }
    @Data
    public static class viewsCnt{
        private Long diaryId;
    }
    @Data
    public static class doLikeIt{
        private Long diaryId;
    }
}
