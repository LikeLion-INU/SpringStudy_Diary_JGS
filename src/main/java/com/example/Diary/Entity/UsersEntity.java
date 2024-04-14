package com.example.Diary.Entity;

import com.example.Diary.Entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class UsersEntity extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "users_id")
    private Long id; // 고유 식별자
    private String usersEmail; // 이메일
    private String usersPassword; // 비밀번호
    private String usersNickname; // 닉네임
    private String birthday;    // 생일
    private String usersPhone; // 전화번호
}
