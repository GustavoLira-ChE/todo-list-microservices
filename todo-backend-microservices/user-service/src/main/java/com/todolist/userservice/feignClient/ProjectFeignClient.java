package com.todolist.userservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.todolist.userservice.model.feign.ProjectModel;

@FeignClient(name = "project-app")
public interface ProjectFeignClient {
    
    @PostMapping
    public ProjectModel save(@RequestBody ProjectModel project);
}
