package com.example.Diary.Dto.Users.UsersRequestDTO;

import com.example.Diary.Entity.UsersEntity;
import lombok.Data;

@Data
public class UsersUpdateRequestDTO {
    private String userEmail; // 이메일
    private String userPassword; // 비밀번호
    private String userNickname; // 닉네임
    private String birthday;    // 생일

    public UsersEntity toEntity() { // DTO를 Users 엔티티로 변환하는 메소드
        return new UsersEntity(this.userEmail, this.userPassword, this.userNickname, this.birthday);
    }
}
