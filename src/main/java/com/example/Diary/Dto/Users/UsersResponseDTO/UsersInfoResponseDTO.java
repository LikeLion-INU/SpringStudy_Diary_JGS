package com.example.Diary.Dto.Users.UsersResponseDTO;

import com.example.Diary.Entity.UsersEntity;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UsersInfoResponseDTO {


    private Long id; // 고유 식별자
    private String userEmail; // 이메일
    private String userPassword; // 비밀번호
    private String userNickname; // 닉네임
    private String birthday;    // 생일

    public UsersInfoResponseDTO(UsersEntity usersEntity) {
        this.id = usersEntity.getId();
        this.userEmail = usersEntity.getUserEmail();
        this.userPassword = usersEntity.getUserPassword();
        this.userNickname = usersEntity.getUserNickname();
        this.birthday = usersEntity.getBirthday();
    }

}
