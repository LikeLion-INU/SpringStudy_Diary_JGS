package com.example.Diary.Service.Users;

import com.example.Diary.Dto.Diary.DiaryDto;
import com.example.Diary.Dto.Diary.DiaryRequestDto;
import com.example.Diary.Dto.Diary.DiaryResponseDto;
import com.example.Diary.Dto.Users.UsersRequestDTO.UsersLoginRequestDTO;
import com.example.Diary.Dto.Users.UsersRequestDTO.UsersSignUpRequestDTO;
import com.example.Diary.Dto.Users.UsersRequestDTO.UsersUpdateRequestDTO;
import com.example.Diary.Dto.Users.UsersResponseDTO.UsersInfoResponseDTO;
import com.example.Diary.Entity.DiaryEntity;
import com.example.Diary.Entity.UsersEntity;
import com.example.Diary.Repository.DiaryRepository;
import com.example.Diary.Repository.FollowRepository;
import com.example.Diary.Repository.Users.UsersRepository;
import com.example.Diary.Repository.ViewerRepository;
import com.example.Diary.common.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsersServicelmpl implements UsersService{

    private final UsersRepository usersRepository;
    private final HttpSession httpSession;
    private final DiaryRepository diaryRepository;
    private final FollowRepository followRepository;
    private final ViewerRepository viewerRepository;

    public UsersInfoResponseDTO signUp(UsersSignUpRequestDTO signUpRequestDTO) {
        log.info("[UsersServiceImpl] signUp");
        UsersEntity usersEntity = signUpRequestDTO.toEntity();
        Optional<UsersEntity> optionalFindMember = usersRepository.findByUserEmail(usersEntity.getUserEmail());
        if (optionalFindMember.isPresent()) {
            // 중복 이메일 발생
            log.info("[ERROR] 중복 이메일 입니다.");
            return null;
        }
        usersRepository.save(usersEntity); // 중복 이메일이 없다면 DB에 저장하기.
        return new UsersInfoResponseDTO(usersEntity);
    }
    public UsersInfoResponseDTO login(UsersLoginRequestDTO loginRequestDTO) {
        log.info("[UsersServiceImpl] login");
        Optional<UsersEntity> optionalFindMember = usersRepository.findByUserEmail(loginRequestDTO.getUserEmail()); // DB에서 회원 조회


        if (optionalFindMember.isEmpty()) {
            // 존재하지 않은 이메일
            log.info("[ERROR] 존재하지 않은 이메일 입니다.");
            return null;
        } else if (!Objects.equals(loginRequestDTO.getUserPassword(), optionalFindMember.get().getUserPassword())) {
            // 틀린 비밀번호
            return null;
        }



        return new UsersInfoResponseDTO(optionalFindMember.get());
    }

    public UsersInfoResponseDTO logout(HttpServletRequest request, long userId) {

        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate(); // 세션 무효화
            log.info("session invalidated {}", session.getId());
        }

        Optional<UsersEntity> optionalFindMember = usersRepository.findById(userId); // DB에서 회원 조회

        if (optionalFindMember.isEmpty()) {
            log.info("[ERROR] 존재하지 않은 회원 입니다.");
            return null;
        }
        return new UsersInfoResponseDTO(optionalFindMember.get());
    }
    public String delete(Long userId) {

        log.info("[UsersServiceImpl] delete");
        Optional<UsersEntity> optionalFindMember = usersRepository.findById(userId);

        if (optionalFindMember.isEmpty()) {
            // 존재하지 않은 이메일
            log.info("[ERROR] 존재하지 않은 회원 입니다.");
            return "FAILURE"; // 삭제 실패를 나타내는 값을 반환
        }

        UsersEntity userToDelete = optionalFindMember.get();
        log.info("[Deleting User] ID: {}", userToDelete.getId());


        usersRepository.deleteById(userId); // DB에서 회원 삭제
        log.info("[User Deletion Successful] ID: {}", userId);

        return "SUCCESS";
    }



    //
    public UsersInfoResponseDTO findOne(Long userId) {

        log.info("[UsersServiceImpl] findOne");

        Optional<UsersEntity> optionalFindMember = usersRepository.findById(userId); // DB에서 회원 조회

        if (optionalFindMember.isEmpty()) {
            // 존재하지 않은 이메일
            log.info("[ERROR] 존재하지 않은 회원 입니다.");
        }

        return new UsersInfoResponseDTO(optionalFindMember.get());
    }

    //

    @Override
    @Transactional
    public UsersInfoResponseDTO update(UsersUpdateRequestDTO updateRequestDTO, Long userId) {


        log.info("[usersServiceImpl] update");
        Optional<UsersEntity> optionalFindMember = usersRepository.findById(userId);

        if(!optionalFindMember.isPresent()) {
            log.info("[ERROR] 존재하지않음");
        }

        UsersEntity userToUpdate = optionalFindMember.get();
        userToUpdate.usersUpdate(updateRequestDTO); // 엔티티 업데이트

        // 변경된 엔티티를 데이터베이스에 저장
        log.info("[Saving User] ID: {}", userToUpdate.getId());
        usersRepository.save(userToUpdate); // 변경된 엔티티를 데이터베이스에 저장
        log.info("[User Saved Successfully] ID: {}", userToUpdate.getId());

        return new UsersInfoResponseDTO(userToUpdate);


    }

    public DiaryResponseDto.DiaryListDto userDiary(Long userId) {

        log.info("[TodoServiceImpl] findAll");
        //회원 id 기준 엔티티리스트에 디비에서 받아오기
        List<DiaryEntity> diaryEntityList = diaryRepository.findAllByUsersId(userId);
        //반환 할 디티오리스트 생성

        List<DiaryDto> diaryDtoList = new ArrayList<>();

        for (DiaryEntity diaryEntity : diaryEntityList) {
            DiaryDto diaryDto = new DiaryDto(diaryEntity);
            diaryDtoList.add(diaryDto);
        }

        // DiaryListDto 생성 후 반환
        return new DiaryResponseDto.DiaryListDto(diaryDtoList);


    }






}
