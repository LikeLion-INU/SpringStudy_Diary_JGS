package com.example.Diary.Service.Users;

import com.example.Diary.Dto.Users.UsersRequestDTO.UsersLoginRequestDTO;
import com.example.Diary.Dto.Users.UsersRequestDTO.UsersSignUpRequestDTO;
import com.example.Diary.Dto.Users.UsersRequestDTO.UsersUpdateRequestDTO;
import com.example.Diary.Dto.Users.UsersResponseDTO.UsersInfoResponseDTO;
import com.example.Diary.Entity.UsersEntity;
import com.example.Diary.Repository.Users.UsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsersServicelmpl implements UsersService{

    private final UsersRepository usersRepository;
    private final HttpSession httpSession;

    public UsersInfoResponseDTO signUp(UsersSignUpRequestDTO signUpRequestDTO) {
        log.info("[UsersServiceImpl] signUp");
        UsersEntity usersEntity = signUpRequestDTO.toEntity();
        Optional<UsersEntity> optionalFindMember = usersRepository.findByUsersEmail(usersEntity.getUsersEmail());
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
        Optional<UsersEntity> optionalFindMember = usersRepository.findByUsersEmail(loginRequestDTO.getUsersEmail()); // DB에서 회원 조회


        if (optionalFindMember.isEmpty()) {
            // 존재하지 않은 이메일
            log.info("[ERROR] 존재하지 않은 이메일 입니다.");
            return null;
        } else if (!Objects.equals(loginRequestDTO.getUsersPassword(), optionalFindMember.get().getUsersPassword())) {
            // 틀린 비밀번호
            return null;
        }



        return new UsersInfoResponseDTO(optionalFindMember.get());
    }

    public UsersInfoResponseDTO logout(HttpServletRequest request, long usersId) {

        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate(); // 세션 무효화
            log.info("session invalidated {}", session.getId());
        }

        Optional<UsersEntity> optionalFindMember = usersRepository.findById(usersId); // DB에서 회원 조회

        if (optionalFindMember.isEmpty()) {
            log.info("[ERROR] 존재하지 않은 회원 입니다.");
            return null;
        }
        return new UsersInfoResponseDTO(optionalFindMember.get());
    }
    public String delete(Long usersId) {

        log.info("[UsersServiceImpl] delete");
        Optional<UsersEntity> optionalFindMember = usersRepository.findById(usersId);

        if (optionalFindMember.isEmpty()) {
            // 존재하지 않은 이메일
            log.info("[ERROR] 존재하지 않은 회원 입니다.");
            return "FAILURE"; // 삭제 실패를 나타내는 값을 반환
        }

        UsersEntity userToDelete = optionalFindMember.get();
        log.info("[Deleting User] ID: {}", userToDelete.getId());


        usersRepository.deleteById(usersId); // DB에서 회원 삭제
        log.info("[User Deletion Successful] ID: {}", usersId);

        return "SUCCESS";
    }



    //
    public UsersInfoResponseDTO findOne(Long usersId) {

        log.info("[UsersServiceImpl] findOne");

        Optional<UsersEntity> optionalFindMember = usersRepository.findById(usersId); // DB에서 회원 조회

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
        log.info("[Updated User Information] Email: {}, Password: {}, Nickname: {}, Birthday: {}",
                updateRequestDTO.getUsersEmail(),
                updateRequestDTO.getUsersPassword(),
                updateRequestDTO.getUsersNickname(),
                updateRequestDTO.getBirthday());


        log.info("[usersServiceImpl] update");
        Optional<UsersEntity> optionalFindMember = usersRepository.findById(userId);

        if(!optionalFindMember.isPresent()) {
            log.info("[ERROR] 존재하지않음");
        }

        UsersEntity userToUpdate = optionalFindMember.get();
        userToUpdate.usersUpdate(updateRequestDTO); // 엔티티 업데이트

        log.info("[Updated User Information] Email: {}, Password: {}, Nickname: {}, Birthday: {}",
                updateRequestDTO.getUsersEmail(),
                updateRequestDTO.getUsersPassword(),
                updateRequestDTO.getUsersNickname(),
                updateRequestDTO.getBirthday());

        // 변경된 엔티티를 데이터베이스에 저장
        log.info("[Saving User] ID: {}", userToUpdate.getId());
        usersRepository.save(userToUpdate); // 변경된 엔티티를 데이터베이스에 저장
        log.info("[User Saved Successfully] ID: {}", userToUpdate.getId());



        return new UsersInfoResponseDTO(userToUpdate);


    }





}
