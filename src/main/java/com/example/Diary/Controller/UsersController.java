package com.example.Diary.Controller;

import com.example.Diary.Dto.Users.UsersRequestDTO.UsersLoginRequestDTO;
import com.example.Diary.Dto.Users.UsersRequestDTO.UsersSignUpRequestDTO;
import com.example.Diary.Dto.Users.UsersRequestDTO.UsersUpdateRequestDTO;
import com.example.Diary.Dto.Users.UsersResponseDTO.UsersInfoResponseDTO;
import com.example.Diary.Service.Users.UsersServicelmpl;
import com.example.Diary.common.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j //logging
@RestController
public class UsersController {

    private final UsersServicelmpl usersService;


    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<?> Signup(@RequestBody UsersSignUpRequestDTO signUpRequestDTO) {
        log.info("[UsersController] signUp");
        UsersInfoResponseDTO result = usersService.signUp(signUpRequestDTO);
        return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "users join success", result));
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody UsersLoginRequestDTO loginRequestDTO, HttpSession httpSession) {
        log.info("[UsersController] login");
        UsersInfoResponseDTO result = usersService.login(loginRequestDTO);

        httpSession.setAttribute("userId", result.getId());


        //세션 확인
        Long userId = (Long) httpSession.getAttribute("userId");
        log.info("Session userId: {}", userId);



        return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "users join success", result));

    }


    // 로그아웃

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession httpSession, HttpServletRequest request) {

        log.info("[UsersController] logout");

        Long userId = (Long) httpSession.getAttribute("userId");
        UsersInfoResponseDTO result = usersService.logout(request, userId);


        log.info("Session userId: {}", userId);
        return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "users logout success", result));
    }



    // 회원 탈퇴
    @PostMapping("/delete")
    public ResponseEntity<?> delete(HttpSession httpSession) {

        log.info("[UsersController] delete");

        Long userId = (Long) httpSession.getAttribute("userId");
        log.info("Session userId: {}", userId);

        String result = usersService.delete(userId);
        return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "users delete success", result));

    }


    @GetMapping("/findOne")
    public ResponseEntity<?> findOne(HttpSession httpSession) {

        log.info("[UsersController] findOne");
        Long usersId = (Long) httpSession.getAttribute("userId");
        UsersInfoResponseDTO result = usersService.findOne(usersId);

        return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(), "member findOne success", result));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UsersUpdateRequestDTO updateRequestDTO, HttpSession httpSession) {

        log.info("[UsersController] update");
        log.info("[Updated User controller] Email: {}, Password: {}, Nickname: {}, Birthday: {}",
                updateRequestDTO.getUsersEmail(),
                updateRequestDTO.getUsersPassword(),
                updateRequestDTO.getUsersNickname(),
                updateRequestDTO.getBirthday());

        Long userId = (Long) httpSession.getAttribute("userId");
        UsersInfoResponseDTO result = usersService.update(updateRequestDTO, userId);

        return ResponseEntity.ok().body(ApiResponse.SUCCESS(HttpStatus.CREATED.value(),"users update success",result));


    }



}
