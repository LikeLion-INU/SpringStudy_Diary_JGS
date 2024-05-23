package com.example.Diary.Dto.Follow;

import com.example.Diary.Entity.Follow;
import com.example.Diary.Entity.UsersEntity;
import lombok.Data;

@Data
public class FollowDTO {
    private int approveYn;
    private UsersEntity reqUsersEntity;
    private UsersEntity resUsersEntity;

    public FollowDTO(Follow follow) {
        this.approveYn = approveYn;
        this.reqUsersEntity = reqUsersEntity;
        this.resUsersEntity = resUsersEntity;
    }
}
