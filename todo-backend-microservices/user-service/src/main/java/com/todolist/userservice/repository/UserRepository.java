package com.todolist.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todolist.userservice.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    @Query(value = "select * from users where user_email = ?1", nativeQuery = true)
    public abstract Optional<UserEntity> findAllByUserId(String userEmail);
}
