package com.example.Diary.Repository;

import com.example.Diary.Entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByApproveYnAndReqUsersEntity_IdAndResUsersEntity_Id(int approveYn, Long requester, Long responser);

    // 팔로잉 (요청자 - 본인 확인) User -> other
    List<Follow> findByReqUsersEntity_Id(Long requester );

    //팔로워 (응답자 -본인 확인) other -> User
    List<Follow> findByResUsersEntity_Id(Long responser );
}
