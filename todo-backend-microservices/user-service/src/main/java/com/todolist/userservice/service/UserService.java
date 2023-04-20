package com.todolist.userservice.service;

import java.util.List;
import java.util.Optional;

import com.todolist.userservice.model.UserEntity;
import com.todolist.userservice.model.feign.ProjectModel;

public interface UserService {

    List<UserEntity> findAll();
    Optional<UserEntity> findById(int userId);
    UserEntity save(UserEntity user);
    void deleteById(int userId);
    ProjectModel saveProject(int userId, ProjectModel project);
    
}
