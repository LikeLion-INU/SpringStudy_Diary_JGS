package com.example.Diary.Dto.Follow;

import com.example.Diary.Entity.Follow;
import com.example.Diary.Entity.UsersEntity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;


@Data
public class FollowRequestDTO {

    private int approveYn;
    private Long reqUserId; // 요청하는 사용자의 ID
    private Long resUserId; // 응답하는 사용자의 ID

    public Follow toEntity(UsersEntity reqUser ,UsersEntity resUser) { // DTO를 user 엔티티로 변환하는 메소드
        return new Follow(this.approveYn, reqUser , resUser);
    }

    @Data
    public static class FollowReq {
        private int approveYn;
        private Long reqUserId; // 요청하는 사용자의 ID
        private Long resUserId; // 응답하는 사용자의 ID

        public Follow toEntity(UsersEntity reqUser ,UsersEntity resUser) { // DTO를 user 엔티티로 변환하는 메소드
            return new Follow(this.approveYn, reqUser, resUser);
        }
    }

    @Data
    public static class FollowApprove {
        private int approveYn;
        private Long reqUserId; // 요청하는 사용자의 ID
        private Long resUserId; // 응답하는 사용자의 ID

        public Follow toEntity(UsersEntity reqUser, UsersEntity resUser) { // DTO를 user 엔티티로 변환하는 메소드
            return new Follow(this.approveYn, reqUser, resUser);

        }
    }

}
