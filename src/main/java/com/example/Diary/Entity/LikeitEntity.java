package com.example.Diary.Entity;

import com.example.Diary.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class LikeitEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likeit_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UsersEntity users;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private DiaryEntity diary;
}
