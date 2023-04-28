package com.todolist.authservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todolist.authservice.dto.UserModel;
import com.todolist.authservice.feignRepository.UserFeignService;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private UserFeignService userFeign;

    @Autowired
    public UserDetailsServiceImp(UserFeignService userFeign){
        this.userFeign = userFeign;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserModel user = this.userFeign.findUserByEmail(username).get();
            return new UserDetailImp(user);
        } catch (Exception e) {
            throw new UsernameNotFoundException("The user's email: " + username + "does not exists");
        }
    }    
}
