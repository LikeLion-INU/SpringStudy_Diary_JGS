package com.example.Diary.Service.Users;

import com.example.Diary.Dto.Users.UsersRequestDTO.UsersLoginRequestDTO;
import com.example.Diary.Dto.Users.UsersRequestDTO.UsersSignUpRequestDTO;
import com.example.Diary.Dto.Users.UsersRequestDTO.UsersUpdateRequestDTO;
import com.example.Diary.Dto.Users.UsersResponseDTO.UsersInfoResponseDTO;
import com.example.Diary.Repository.Users.UsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public interface UsersService {
    UsersInfoResponseDTO signUp (UsersSignUpRequestDTO signUpRequestDTO);

    UsersInfoResponseDTO login(UsersLoginRequestDTO loginRequestDTO);

    UsersInfoResponseDTO logout(HttpServletRequest request , long userId);

    String delete(Long userId);

    UsersInfoResponseDTO findOne(Long userId);

    UsersInfoResponseDTO update(UsersUpdateRequestDTO updateRequestDTO, Long userId);
}
