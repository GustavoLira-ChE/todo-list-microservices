package com.todolist.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.authservice.dto.AuthCredentials;
import com.todolist.authservice.dto.NewUserInfo;
import com.todolist.authservice.dto.UserModel;
import com.todolist.authservice.service.AuthService;

@RestController
@RequestMapping()
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthCredentials credentials) {
        String token = authService.login(credentials);
        if(token == null){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<String>(token, HttpStatus.ACCEPTED);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validate(@RequestParam String token) {
        String validToken = this.authService.validateToken(token);
        if(validToken == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(validToken);
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserModel> signUp(@RequestBody NewUserInfo user) {
        UserModel newUser = this.authService.saveUser(user);
        if(newUser == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(newUser);
    }
    
}
