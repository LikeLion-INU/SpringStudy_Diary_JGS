package com.example.Diary.Repository;

import com.example.Diary.Entity.PhotoFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoFileRepository extends JpaRepository<PhotoFile, Long> {
    Long countAllByDiaryEntity_Id(Long diaryId);
    List<PhotoFile> findByDiaryEntity_Id(Long diaryId);
}
