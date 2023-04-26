package com.todolist.projectservice.model.feign;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel {

    private int task_id;
    private String task_name;
    private Date task_due_date;
    private boolean task_is_completed;
    private int project_id;
    
}
