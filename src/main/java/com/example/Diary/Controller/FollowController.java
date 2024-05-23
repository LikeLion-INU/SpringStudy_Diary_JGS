package com.example.Diary.Controller;


import com.example.Diary.Dto.Follow.FollowRequestDTO;
import com.example.Diary.Service.Follow.FollowServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {

    private final FollowServiceImpl followService;


    @GetMapping("/following")
    public ResponseEntity<?> followingList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        return ResponseEntity.ok().body(followService.followingList(userId));
    }

    @GetMapping("/follower")
    public ResponseEntity<?> followerList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        return ResponseEntity.ok().body(followService.followerList(userId));
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



}
