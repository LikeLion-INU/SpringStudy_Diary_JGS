package com.example.Diary.Entity;

import com.example.Diary.Entity.BaseEntity;
import com.example.Diary.Entity.UsersEntity;
import com.example.Diary.Entity.DiaryEntity;
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
