package com.example.Diary.Entity;

import com.example.Diary.Entity.BaseEntity;
import com.example.Diary.Entity.UsersEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class DiaryEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private Long id;    //고유 식별자
    private int publicState;   //공개상태 (0:전체공개 1:비공개 2:일부공개)
    @Column(name = "record_date")
    private LocalDate recordDate;   //일기상 날짜
    private int weather;     //날씨
    private String title;   //제목
    private String contents; //내용
    private  int photoYn;  //사진유무 (0:X 1:O)

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UsersEntity users;







}
