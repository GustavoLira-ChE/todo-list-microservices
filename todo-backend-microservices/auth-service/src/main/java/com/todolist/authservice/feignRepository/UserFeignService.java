package com.todolist.authservice.feignRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.authservice.dto.NewUserInfo;
import com.todolist.authservice.dto.UserModel;

@Service
public class UserFeignService {

    private UserFeign userFeign;

    @Autowired
    public UserFeignService(UserFeign userFeign){
        this.userFeign = userFeign;
    }

    public Optional<UserModel> findUserByEmail(String userEmail) {
        return Optional.of(this.userFeign.findUserByEmail(userEmail));
    }

    public UserModel saveNewUser(NewUserInfo newUser){
        UserModel user = new UserModel();
        user.setUser_email(newUser.getUser_email());
        user.setUser_password(newUser.getUser_password());
        user.setUser_name(newUser.getUser_name());
        user.setUser_role("REGULAR");
        return this.userFeign.save(user);
    }
    
}
