package com.example.Diary.Entity;

import com.example.Diary.Dto.Users.UsersRequestDTO.UsersSignUpRequestDTO;
import com.example.Diary.Dto.Users.UsersRequestDTO.UsersUpdateRequestDTO;
import com.example.Diary.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class UsersEntity extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id; // 고유 식별자
    private String userEmail; // 이메일
    private String userPassword; // 비밀번호
    private String userNickname; // 닉네임
    private String birthday;    // 생일


    public UsersEntity(String userEmail, String userPassword, String userNickname, String birthday) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
        this.birthday = birthday;
    }


    public void usersUpdate(UsersUpdateRequestDTO updateRequestDTO){
        if (updateRequestDTO.getUserEmail() != null) {
            this.userEmail = updateRequestDTO.getUserEmail();
        }
        if (updateRequestDTO.getUserPassword() != null) {
            this.userPassword = updateRequestDTO.getUserPassword();
        }
        if (updateRequestDTO.getUserNickname() != null) {
            this.userNickname = updateRequestDTO.getUserNickname();
        }
        if (updateRequestDTO.getBirthday() != null) {
            this.birthday = updateRequestDTO.getBirthday();
        }
    }


}

    /*
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<Viewer> viewerList;

    @OneToMany(mappedBy = "reqUsersEntity", fetch = FetchType.LAZY)
    private List<Follow> reqFollowList;

    @OneToMany(mappedBy = "resUsersEntity", fetch = FetchType.LAZY)
    private List<Follow> resFollowList;



*/