package com.example.Diary.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Follow extends BaseEntity{
    private int approveYn;

    @ManyToOne
    @JoinColumn(name = "requester")
    private UsersEntity reqUsersEntity;

    @ManyToOne
    @JoinColumn(name = "responser")
    private UsersEntity resUsersEntity;
}
