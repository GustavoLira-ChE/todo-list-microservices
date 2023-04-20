package com.todolist.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.userservice.feignClient.ProjectFeignClient;
import com.todolist.userservice.model.UserEntity;
import com.todolist.userservice.model.feign.ProjectModel;
import com.todolist.userservice.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepo;
    private ProjectFeignClient projectFeign;
    @Autowired
    public UserServiceImplementation(UserRepository userRepo, ProjectFeignClient projectFeign){
        this.userRepo = userRepo;
        this.projectFeign = projectFeign;
    }

    @Override
    public List<UserEntity> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public Optional<UserEntity> findById(int userId) {
        return this.userRepo.findById(userId);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return this.userRepo.save(user);
    }

    @Override
    public void deleteById(int userId) {
        boolean exist = this.userRepo.existsById(userId);
        if(exist){
            this.userRepo.deleteById(userId);
        } else {
            System.out.println("User doesn't exist");
        }
    }

    @Override
    public ProjectModel saveProject(int userId, ProjectModel project){
        project.setUser_id(userId);
        ProjectModel newProject = this.projectFeign.save(project);
        return newProject;
    }
    
}


