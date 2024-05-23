package com.example.Diary.Service.Follow;


import com.example.Diary.Dto.Diary.DiaryDto;
import com.example.Diary.Dto.Diary.DiaryResponseDto;
import com.example.Diary.Dto.Follow.FollowRequestDTO;
import com.example.Diary.Dto.Follow.FollowResponseDTO;
import com.example.Diary.Dto.Users.UsersResponseDTO.UsersInfoResponseDTO;
import com.example.Diary.Entity.DiaryEntity;
import com.example.Diary.Entity.Follow;
import com.example.Diary.Entity.UsersEntity;
import com.example.Diary.Repository.DiaryRepository;
import com.example.Diary.Repository.FollowRepository;
import com.example.Diary.Repository.Users.UsersRepository;
import com.example.Diary.Repository.ViewerRepository;
import com.example.Diary.common.ApiResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FollowServiceImpl {

    private final FollowRepository followRepository;
    private final UsersRepository usersRepository;
    private final DiaryRepository diaryRepository;
    private final ViewerRepository viewerRepository;


    // 사용자 팔로잉 확인 리스트
    public FollowResponseDTO.FollwingListDTO followingList(Long userId) {
        List<Follow> followingEntityList = followRepository.findByReqUsersEntity_Id(userId);
        List<FollowResponseDTO> followingDTOList = new ArrayList<>();

        for (Follow follow : followingEntityList) {
            FollowResponseDTO followingDto = new FollowResponseDTO(follow);
            followingDTOList.add(followingDto);
        }

        // DiaryListDto 생성 후 반환
        return new FollowResponseDTO.FollwingListDTO(followingDTOList);
    }

    //사용자 팔로우 확인 리스트
    public FollowResponseDTO.FollwerListDTO followerList(Long userId) {
        List<Follow> followerEntityList = followRepository.findByResUsersEntity_Id(userId);
        List<FollowResponseDTO> followerDTOList = new ArrayList<>();

        for (Follow follow : followerEntityList) {
            FollowResponseDTO followerDto = new FollowResponseDTO(follow);
            followerDTOList.add(followerDto);
        }

        return new FollowResponseDTO.FollwerListDTO(followerDTOList);
    }


    //팔로우 요청 - followReq
    public FollowResponseDTO followRequest(Long userId, FollowRequestDTO.FollowReq followReqDTO) {

        // approveyn - 0 , request 본인 , response 상대방 , 본인 -> 상대방
        // 존재하는 유저 확인
        // Optional<Follow> optionalFindMember = followRepository.findById(userId);

        //userid = reqid

        Optional<UsersEntity> optionalFindReqMember = usersRepository.findById(followReqDTO.getReqUserId());
        Optional<UsersEntity> optionalFindResMember = usersRepository.findById(followReqDTO.getResUserId());

        // user, response 둘다 존재해야함
        if (optionalFindReqMember.isEmpty() || optionalFindResMember.isEmpty()) {
            log.info("user or response user is empty");
            return null;
        }

        // userId와 reqUserId가 일치하는지 확인
        if (!userId.equals(followReqDTO.getReqUserId())) {
            log.info("userId does not match request user id");
            return null;
        }

        UsersEntity requestUser = optionalFindReqMember.get();
        UsersEntity responseUser = optionalFindResMember.get();


        Optional<Follow> optionalFollow =
                followRepository.findByApproveYnAndReqUsersEntity_IdAndResUsersEntity_Id
                        (0, followReqDTO.getReqUserId(), followReqDTO.getResUserId());
        if (optionalFollow.isPresent()) {
            log.info("이미 팔로우 신청");
            return null;
        }


        // User 엔티티 + reqDTO 받아서 팔로우 엔티티로 변환
        Follow followReq = new Follow(0, requestUser, responseUser);
        followRepository.save(followReq);

        return new FollowResponseDTO(followReq);

    }

    //사용자 팔로우 승인 -followApprove
    @Transactional
    public FollowResponseDTO followApprove(Long userId, FollowRequestDTO.FollowApprove followApproveDTO) {

        //approveyn = 0 , request 상대 , response 본인 , 상대 -> 본인
        //approbeyn = 1 변경(승인) request 상대 , response 본인 저장

        // userid = responseid

        Optional<UsersEntity> optionalFindReqMember = usersRepository.findById(followApproveDTO.getReqUserId());
        Optional<UsersEntity> optionalFindResMember = usersRepository.findById(followApproveDTO.getResUserId());


        //user, response 둘다 존재해야함
        if (optionalFindReqMember.isEmpty() && optionalFindResMember.isEmpty()) {
            log.info(" user, req empty");
            return null;
        }
        //userid = response id
        if (!userId.equals(followApproveDTO.getResUserId())) {
            log.info(" user != response id");
            return null;
        }

        UsersEntity requestUser = optionalFindReqMember.get();
        UsersEntity responseUser = optionalFindResMember.get();


        Optional<Follow> optionalFollow =
                followRepository.findByApproveYnAndReqUsersEntity_IdAndResUsersEntity_Id
                        (0, followApproveDTO.getReqUserId(), followApproveDTO.getResUserId());

        if (optionalFollow.isEmpty()) {
//            followRepository.save(follow);
            //User 엔티티 + req디티오 받아서 팔로우엔티티로변환
            return null;
        }
        Follow follow = optionalFollow.get();
        follow.approve();


//        Follow follow = new Follow(1, requestUser, responseUser);
//        followRepository.save(follow);
        return new FollowResponseDTO(follow);
    }


    // 1.userid,reqid 존재 확인. 2.userid= req 일치 확인


    // 팔로우 리스트 조회 - getFollowList

    /**
     * 미승인 팔로우 리스트 조회
     * @param userId Long - 사용자 구분자
     * @return FollowResponseDTO.getNotApproveFollowList
     */
    public ApiResponse<?> getNotApproveFollowList(Long userId) {
        // 1. 사용자 조회
        Optional<UsersEntity> usersOpt = usersRepository.findById(userId);
        if(usersOpt.isEmpty()) return ApiResponse.ERROR(401, "존재하지 않는 user 입니다.");

        // 2. 미승인 팔로우 리스트 조회
        List<Follow> followList = followRepository.findByApproveYnAndResUsersEntity_Id(0, userId);

        // 3. DTO 전환
        List<FollowResponseDTO.getNotApproveFollow> result = new ArrayList<>();
        for (Follow entity : followList)
            result.add(new FollowResponseDTO.getNotApproveFollow(entity));

        // 4. return
        return ApiResponse.SUCCESS(201, "SUCCESS", new FollowResponseDTO.getNotApproveFollowList(result));
    }

}






