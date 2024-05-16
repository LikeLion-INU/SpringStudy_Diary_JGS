package com.example.Diary.Dto.Diary;

import com.example.Diary.Entity.DiaryEntity;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DiaryDto {
    private Long diaryId;       //고유 식별자
    private int publicState;    //공개상태 (0:전체공개 1:비공개 2:일부공개)
    private LocalDate recordDate;   //일기상 날짜
    private String weather;     // 날씨
    private Double tempMin;     // 최저 온도
    private Double tempMax;     // 최고 온도
    private String title;       //제목
    private String contents;    //내용
    private int photoYn;        //사진유무 (0:X 1:O)
    private int viewsCnt;        //사진유무 (0:X 1:O)

    public DiaryDto(DiaryEntity entity){
        this.diaryId = entity.getId();
        this.publicState = entity.getPublicState();
        this.recordDate = entity.getRecordDate();
        this.weather = entity.getWeather();
        this.tempMin = entity.getTempMin();
        this.tempMax = entity.getTempMax();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.photoYn = entity.getPhotoYn();
        this.viewsCnt = entity.getViewsCnt();
    }
}
