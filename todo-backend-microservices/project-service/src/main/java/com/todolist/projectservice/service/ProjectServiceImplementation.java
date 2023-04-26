package com.todolist.projectservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.projectservice.feignClient.TaskFeignClient;
import com.todolist.projectservice.model.ProjectEntity;
import com.todolist.projectservice.model.feign.TaskModel;
import com.todolist.projectservice.repository.ProjectRepository;

@Service
public class ProjectServiceImplementation implements ProjectService{

    private ProjectRepository projectRepo;
    private TaskFeignClient taskFeign;

    @Autowired
    public ProjectServiceImplementation(ProjectRepository projectRepo, TaskFeignClient taskFeign){
        this.projectRepo = projectRepo;
        this.taskFeign = taskFeign;
    }

    @Override
    public List<ProjectEntity> findAll(){
        return projectRepo.findAll();
    }

    @Override
    public Optional<ProjectEntity> findById(int projectId){
        return this.projectRepo.findById(projectId);
    }

    @Override
    public ProjectEntity save(ProjectEntity project) {
        return this.projectRepo.save(project);
    }

    @Override
    public void deleteById(int projectId) {
        boolean exist = this.projectRepo.existsById(projectId);
        if(exist){
            this.projectRepo.deleteById(projectId);
        } 
    }

    @Override
    public List<ProjectEntity> findAllByUserId(int userId) {
        return this.projectRepo.findAllByUserId(userId);
    }

    @Override
    public TaskModel saveTask(int projectId,TaskModel task) {
        task.setProject_id(projectId);
        TaskModel newTask = this.taskFeign.save(task); 
        return newTask;
    }

    @Override
    public List<TaskModel> findAllTaskByProjectId(int projectId) {
        return this.taskFeign.findAllByProjectId(projectId);
    }

}
