package com.todolist.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.taskservice.model.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {
    
}
