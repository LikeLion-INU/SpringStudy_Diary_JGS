package com.example.Diary.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Viewer extends BaseEntity{
    @ManyToOne
    @JoinColumn(name="diary_id")
    private DiaryEntity diaryEntity;    // 볼 수 있는 일기

    @ManyToOne
    @JoinColumn(name="users_id")
    private UsersEntity usersEntity;    // 뷰가 가능한 사용자

}
