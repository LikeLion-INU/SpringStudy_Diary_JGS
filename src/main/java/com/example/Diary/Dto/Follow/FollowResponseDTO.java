package com.example.Diary.Dto.Follow;

import com.example.Diary.Dto.Diary.DiaryDto;
import com.example.Diary.Entity.Follow;
import com.example.Diary.Entity.UsersEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class FollowResponseDTO {

    private Long id;
    private int approveYn;
    private Long reqUserId; // 요청하는 사용자의 ID
    private Long resUserId; // 응답하는 사용자의 ID

    public FollowResponseDTO(Follow follow) {
        this.id = follow.getId();
        this.approveYn = follow.getApproveYn();
        this.reqUserId = follow.getReqUsersEntity().getId();
        this.resUserId = follow.getResUsersEntity().getId();
    }

    public static class FollwingListDTO {
        private List<FollowResponseDTO> follwingListDTO;
        public FollwingListDTO(List<FollowResponseDTO> follwingListDTO) {

            this.follwingListDTO = follwingListDTO;
        }
    }

    public static class FollwerListDTO {
        private List<FollowResponseDTO> follwerListDTO;
        public FollwerListDTO(List<FollowResponseDTO> follwerListDTO) {

            this.follwerListDTO = follwerListDTO;
        }
    }

    @Getter
    public static class getNotApproveFollowList {
        private List<getNotApproveFollow> list;
        public getNotApproveFollowList(List<getNotApproveFollow> list){
            this.list = list;
        }
    }

    @Getter
    public static class getNotApproveFollow {
        private Long id;
        private String requesterNickname;

        public getNotApproveFollow(Follow entity){
            this.id = entity.getId();
            this.requesterNickname = entity.getReqUsersEntity().getUserNickname();
        }
    }


}
