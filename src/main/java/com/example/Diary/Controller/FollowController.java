package com.example.Diary.Controller;


import com.example.Diary.Dto.Follow.FollowRequestDTO;
import com.example.Diary.Dto.Follow.FollowResponseDTO;
import com.example.Diary.Dto.Users.UsersResponseDTO.UsersInfoResponseDTO;
import com.example.Diary.Service.Follow.FollowServiceImpl;
import com.example.Diary.common.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {

    private final FollowServiceImpl followService;


    @PostMapping("/following")
    public ResponseEntity<?> followingList(HttpSession httpSession) {

        Long userId = (Long) httpSession.getAttribute("userId");
        FollowResponseDTO.FollwingListDTO result = followService.followingList(userId);

        return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "following List", result));
    }

    @PostMapping("/follower")
    public ResponseEntity<?> followerList(HttpSession httpSession) {

        Long userId = (Long) httpSession.getAttribute("userId");
        FollowResponseDTO.FollwerListDTO result = followService.followerList(userId);

        return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "follower List", result));
    }

    //팔로우 요청 - followReq
    @PostMapping("/followRequest")
    public ResponseEntity<?> followReq(HttpServletRequest request,@RequestBody FollowRequestDTO.FollowReq followReqDTO) {
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        return ResponseEntity.ok().body(followService.followRequest(userId, followReqDTO));
    }

    //팔로우 승인 - followOpp
    @PostMapping("/followApprove")
    public ResponseEntity<?> followApprove(HttpServletRequest request,@RequestBody FollowRequestDTO.FollowApprove followApproveDTO) {
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        return ResponseEntity.ok().body(followService.followApprove(userId, followApproveDTO));
    }

    /**
     * 미승인 팔로우 리스트 조회
     * @param request HttpServletRequest
     * @return ResponseEntity<?>
     */
    @PostMapping("/getNotApproveFollowList")
    public ResponseEntity<?> getNotApproveFollowList(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        return ResponseEntity.ok().body(followService.getNotApproveFollowList(userId));
    }


}
