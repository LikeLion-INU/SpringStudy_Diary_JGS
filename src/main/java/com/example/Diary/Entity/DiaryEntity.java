package com.example.Diary.Entity;

import com.example.Diary.Entity.BaseEntity;
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
    private int public_state;   //공개상태 (0:전체공개 1:비공개 2:일부공개)
    @Column(name = "record_date")
    private LocalDate record_date;   //일기상 날짜
    private int weater;     //날씨
    private String title;   //제목
    private String contents; //내용
    private  int photo_yn;  //사진유무 (0:X 1:O)

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UsersEntity users;





}
