package com.example.Diary.Entity;

import com.example.Diary.Dto.Follow.FollowRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Follow extends BaseEntity{
    @Id
    @GeneratedValue
    @Column (name = "follow_id")
    private  Long id;

    private int approveYn;

    @ManyToOne
    @JoinColumn(name = "requester")
    private UsersEntity reqUsersEntity;

    @ManyToOne
    @JoinColumn(name = "responser")
    private UsersEntity resUsersEntity;


    public Follow (int approveYn, UsersEntity reqUsersEntity, UsersEntity resUsersEntity) {
        this.approveYn = approveYn;
        this.reqUsersEntity = reqUsersEntity;
        this.resUsersEntity = resUsersEntity;
    }

    public Follow() {

    }

    /*
    public void followUpdate (FollowRequestDTO followRequestDTO) {
        this.approveYn = followRequestDTO.getApproveYn();
        this.reqUsersEntity = followRequestDTO.getReqUsersEntity();
        this.resUsersEntity = followRequestDTO.getResUsersEntity();
    }
    */


}
