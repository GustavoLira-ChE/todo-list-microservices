package com.todolist.userservice.service;

import java.util.List;
import java.util.Optional;

import com.todolist.userservice.model.UserEntity;

public interface UserService {

    List<UserEntity> findAll();
    Optional<UserEntity> findById(int userId);
    UserEntity save(UserEntity user);
    void deleteById(int userId);

}
