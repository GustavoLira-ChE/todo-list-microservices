package com.todolist.authservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todolist.authservice.dto.AuthCredentials;
import com.todolist.authservice.dto.NewUserInfo;
import com.todolist.authservice.dto.UserModel;
import com.todolist.authservice.feignRepository.UserFeignService;
import com.todolist.authservice.security.JwtProvider;

@Service
public class AuthService {
    
    private UserFeignService userFeign;
    private JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserFeignService userFeign, JwtProvider jwtProvider, PasswordEncoder passwordEncoder) {
        this.userFeign = userFeign;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel saveUser(NewUserInfo user) {
        Optional<UserModel> checkUser = this.userFeign.findUserByEmail(user.getUser_email());
        if(checkUser.isPresent()){
            return null;
        }
        return this.userFeign.saveNewUser(user);
    }

    public String login(AuthCredentials credentials) {
        Optional<UserModel> user = this.userFeign.findUserByEmail(credentials.getUser_email());
        if(!user.isPresent()){
            return null;
        }
        if(passwordEncoder.matches(credentials.getUser_password(), user.get().getUser_password())){
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(user.get().getUser_role()));
            return jwtProvider.createToken(user.get().getUser_name(), user.get().getUser_email(), roles);
        }
        return null;
    }

    public String validateToken(String token){
        if(jwtProvider.validateToken(token)){
            String userEmail = this.jwtProvider.getUserEmail(token);
            if(this.userFeign.findUserByEmail(userEmail).isPresent()){
                return token;
            }
            return null;
        }        
        return null;
    }
}
