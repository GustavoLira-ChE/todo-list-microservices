package com.todolist.userservice.model.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectModel {

    private int project_id;
    private String project_name;
    private int user_id;
    
}
