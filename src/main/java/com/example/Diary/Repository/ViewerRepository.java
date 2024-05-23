package com.example.Diary.Repository;

import com.example.Diary.Entity.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ViewerRepository extends JpaRepository<Viewer, Long> {
    Optional<Viewer> findByDiaryEntity_IdAndUsersEntity_Id(Long diaryId, Long usersId);
    List<Viewer> findByDiaryEntity_Id(Long diaryId);
}
