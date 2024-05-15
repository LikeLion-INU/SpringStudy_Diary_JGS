package com.example.Diary.Dto.Users.UsersResponseDTO;

import com.example.Diary.Entity.UsersEntity;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UsersInfoResponseDTO {


    private Long id; // 고유 식별자
    private String usersEmail; // 이메일
    private String usersPassword; // 비밀번호
    private String usersNickname; // 닉네임
    private String birthday;    // 생일

    public UsersInfoResponseDTO(UsersEntity usersEntity) {
        this.id = usersEntity.getId();
        this.usersEmail = usersEntity.getUsersEmail();
        this.usersPassword = usersEntity.getUsersPassword();
        this.usersNickname = usersEntity.getUsersNickname();
        this.birthday = usersEntity.getBirthday();
    }

}
