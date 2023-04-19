package com.todolist.taskservice.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tasks")
public class TaskEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int task_id;
    @Column(name = "task_name")
    private String task_name;
    @Column(name = "task_due_date")
    private Date task_due_date;
    @Column(name = "task_is_completed", columnDefinition = "BOOLEAN")
    private boolean task_is_completed;
    @Column(name = "project_id")
    private int project_id;

}
