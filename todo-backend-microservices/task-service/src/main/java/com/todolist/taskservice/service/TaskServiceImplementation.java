package com.todolist.taskservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.taskservice.model.TaskEntity;
import com.todolist.taskservice.repository.TaskRepository;

@Service
public class TaskServiceImplementation implements TaskService {

    private TaskRepository taskRepo;

    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepo){
        this.taskRepo = taskRepo;
    }

    @Override
    public List<TaskEntity> findAll() {
        return this.taskRepo.findAll();
    }

    @Override
    public Optional<TaskEntity> findById(int taskId) {
        return this.taskRepo.findById(taskId);
    }

    @Override
    public TaskEntity save(TaskEntity task) {
        return this.taskRepo.save(task);
    }

    @Override
    public void deleteById(int taskId) {
        if(this.taskRepo.existsById(taskId)){
            this.taskRepo.deleteById(taskId);
        }
    }

    @Override
    public List<TaskEntity> findAllByProjectId(int projectId) {
        return this.taskRepo.findAllByProjectId(projectId);
    }
    
}
