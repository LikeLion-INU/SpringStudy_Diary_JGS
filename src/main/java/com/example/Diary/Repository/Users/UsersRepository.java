package com.example.Diary.Repository.Users;

import com.example.Diary.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository  extends JpaRepository<UsersEntity, Long> {

    Optional<UsersEntity> findByUserEmail(String usersEmail);
}