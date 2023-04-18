package com.todolist.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.userservice.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    
}
