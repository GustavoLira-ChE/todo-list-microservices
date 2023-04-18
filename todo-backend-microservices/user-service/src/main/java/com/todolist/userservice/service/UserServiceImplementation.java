package com.todolist.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.userservice.model.UserEntity;
import com.todolist.userservice.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepo;
    @Autowired
    public UserServiceImplementation(UserRepository userRepo){
        this.userRepo = userRepo;
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
    
}


