package com.todolist.authservice.feignRepository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.todolist.authservice.dto.UserModel;

@FeignClient(name = "user-app")
public interface UserFeign {
    
    @GetMapping("/user-email/{email}")
    public UserModel findUserByEmail(@PathVariable(name = "email") String userEmail);

    @PostMapping
    public UserModel save(@RequestBody UserModel user);
    
}
