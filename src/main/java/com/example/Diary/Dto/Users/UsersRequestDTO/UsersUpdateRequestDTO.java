package com.example.Diary.Dto.Users.UsersRequestDTO;

import com.example.Diary.Entity.UsersEntity;
import lombok.Data;

@Data
public class UsersUpdateRequestDTO {
    private String usersEmail; // 이메일
    private String usersPassword; // 비밀번호
    private String usersNickname; // 닉네임
    private String birthday;    // 생일

    public UsersEntity toEntity() { // DTO를 Users 엔티티로 변환하는 메소드
        return new UsersEntity(this.usersEmail, this.usersPassword, this.usersNickname, this.birthday);
    }
}
