package com.example.Diary.Repository;

import com.example.Diary.Entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByApproveYnAndReqUsersEntity_IdAndResUsersEntity_Id(int approveYn, Long requester, Long responser);
}
