package com.todolist.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    
    private int user_id;
    private String user_name;
    private String user_email;
    private String user_password;
    private String user_role;
}
