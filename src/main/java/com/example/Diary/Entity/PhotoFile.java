package com.example.Diary.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoFile extends BaseEntity{

    private String origFilename;    // 원본 파일명
    private String fileUuid;    // 파일 UUID

    @ManyToOne
    @JoinColumn(name="diary_id")
    private DiaryEntity diaryEntity;
}
