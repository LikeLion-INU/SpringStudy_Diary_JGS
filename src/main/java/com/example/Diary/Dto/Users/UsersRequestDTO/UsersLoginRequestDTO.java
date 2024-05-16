package com.example.Diary.Dto.Users.UsersRequestDTO;

import com.example.Diary.Entity.UsersEntity;
import jakarta.persistence.Column;
import lombok.Data;

@Data
//로그인 DTO
public class UsersLoginRequestDTO {

    private String userEmail; // 이메일
    private String userPassword; // 비밀번호




}
