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
    @Column(name = "users_id")
    private Long id; // 고유 식별자
    private String usersEmail; // 이메일
    private String usersPassword; // 비밀번호
    private String usersNickname; // 닉네임
    private String birthday;    // 생일


    public UsersEntity(String usersEmail, String usersPassword, String usersNickname, String birthday) {
        this.usersEmail = usersEmail;
        this.usersPassword = usersPassword;
        this.usersNickname = usersNickname;
        this.birthday = birthday;
    }

    public void usersUpdate(UsersUpdateRequestDTO updateRequestDTO){
        if (updateRequestDTO.getUsersEmail() != null) {
            this.usersEmail = updateRequestDTO.getUsersEmail();
        }
        if (updateRequestDTO.getUsersPassword() != null) {
            this.usersPassword = updateRequestDTO.getUsersPassword();
        }
        if (updateRequestDTO.getUsersNickname() != null) {
            this.usersNickname = updateRequestDTO.getUsersNickname();
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