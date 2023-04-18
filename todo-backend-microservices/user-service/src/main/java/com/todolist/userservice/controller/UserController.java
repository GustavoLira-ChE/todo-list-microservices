package com.todolist.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.userservice.model.UserEntity;
import com.todolist.userservice.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserEntity>> findAll(){
        Optional<List<UserEntity>> users = Optional.of(this.userService.findAll());
        if(users.isPresent()){
            return ResponseEntity.ok(this.userService.findAll());
        } else {
            return new ResponseEntity<List<UserEntity>>(HttpStatus.NO_CONTENT);
        } 
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserEntity> showUserDetails(@PathVariable(name="id") int id){
        UserEntity user;
        if(this.userService.findById(id).isPresent()){
            user = this.userService.findById(id).get();
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public UserEntity save(@RequestBody UserEntity user){
        return this.userService.save(user);
    }
    
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable int id){
        if(this.userService.findById(id).isPresent()){
            this.userService.deleteById(id);
            return ResponseEntity.ok(true);
        } else {
            return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
        }
    }
}
