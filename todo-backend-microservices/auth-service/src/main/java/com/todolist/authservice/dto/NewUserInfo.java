package com.todolist.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserInfo {

    private String user_name;
    private String user_email;
    private String user_password;
    
}
