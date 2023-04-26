package com.todolist.projectservice.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.todolist.projectservice.model.feign.TaskModel;

@FeignClient(name = "task-app")
public interface TaskFeignClient {

    @PostMapping
    public TaskModel save(@RequestBody TaskModel task);

    @GetMapping("/project-id/{id}")
    public List<TaskModel> findAllByProjectId(@PathVariable(name = "id") int projectId);
    
}
