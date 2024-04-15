package com.example.Diary.Entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class PhotoFile extends BaseEntity{

    private String fileName;    // 파일명

    @ManyToOne
    @JoinColumn(name="diary_id")
    private DiaryEntity diaryEntity;
}
