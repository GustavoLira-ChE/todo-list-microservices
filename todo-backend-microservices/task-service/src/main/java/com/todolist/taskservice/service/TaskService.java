package com.todolist.taskservice.service;

import java.util.List;
import java.util.Optional;

import com.todolist.taskservice.model.TaskEntity;

public interface TaskService {
    
    List<TaskEntity> findAll();
    Optional<TaskEntity> findById(int taskId);
    TaskEntity save(TaskEntity task);
    void deleteById(int taskId);

    List<TaskEntity> findAllByProjectId(int projectId);
}
