package com.example.Diary.Service.Follow;

import com.example.Diary.Dto.Follow.FollowRequestDTO;
import com.example.Diary.Dto.Follow.FollowResponseDTO;

public interface FollowService {

    //팔로잉 리스트 조회 - followingList
    FollowResponseDTO.FollwingListDTO followingList(Long userId);

    //팔로워 리스트 조회 - followerList
    FollowResponseDTO.FollwerListDTO followerList(Long userId);

    //팔로우 요청 - followReq
    FollowResponseDTO followRequest(Long userId, FollowRequestDTO.FollowReq followReqDTO);

    //팔로우 승인 - followOpp
    FollowResponseDTO followerApprove(Long userId, FollowRequestDTO.FollowApprove followApproveDTO);


}
