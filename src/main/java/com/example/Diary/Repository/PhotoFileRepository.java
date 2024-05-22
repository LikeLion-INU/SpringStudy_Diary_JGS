package com.example.Diary.Repository;

import com.example.Diary.Entity.PhotoFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoFileRepository extends JpaRepository<PhotoFile, Long> {
    Long countAllByDiaryEntity_Id(Long diaryId);
}
