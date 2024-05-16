package com.example.Diary.Repository;

import com.example.Diary.Entity.DiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Long> {

    List<DiaryEntity> findAllByUsersId(Long id);

    @Query(value = "select de.* "+
            "from diary_entity de "+
            "left outer join follow f  "+
            "  on f.responser = de.users_id  "+
            "  and f.requester = :userId "+
            "  and f.approve_yn = 1 "+
            "left outer join viewer v  "+
            "  on v.diary_id = de.id  "+
            "  and v.users_id = :userId "+
            "where (de.users_id = :userId) "+
            "or (de.public_state = 0 and f.id != null) "+
            "or (de.public_state = 1 and f.id != null and v.id != null)", nativeQuery = true)
    List<DiaryEntity> canViewDiaryList(@Param("userId") Long userId);
}
