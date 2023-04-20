package com.todolist.taskservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.taskservice.model.TaskEntity;
import com.todolist.taskservice.service.TaskService;

@RestController
@RequestMapping()
public class TaskController {
    
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskEntity>> findAll() {
        Optional<List<TaskEntity>> tasks = Optional.of(this.taskService.findAll());
        if(tasks.isPresent()){
            return ResponseEntity.ok(tasks.get());
        } else {
            return new ResponseEntity<List<TaskEntity>>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TaskEntity> findById(@PathVariable(name = "id") int taskId) {
        Optional<TaskEntity> task = this.taskService.findById(taskId);
        if(task.isPresent()){
            return ResponseEntity.ok(task.get());
        } else {
            return new ResponseEntity<TaskEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TaskEntity> save(@RequestBody TaskEntity task){
        TaskEntity newTask;
        try{
            newTask = this.taskService.save(task);
            return ResponseEntity.ok(newTask);
        } catch(Exception e){
            return new ResponseEntity<TaskEntity>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") int taskId){
        if(this.taskService.findById(taskId).isPresent()){
            this.taskService.deleteById(taskId);
            return ResponseEntity.ok(true);
        } else {
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
