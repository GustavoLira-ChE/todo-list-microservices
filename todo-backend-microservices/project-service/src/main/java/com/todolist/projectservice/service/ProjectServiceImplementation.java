package com.todolist.projectservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.projectservice.model.ProjectEntity;
import com.todolist.projectservice.repository.ProjectRepository;

@Service
public class ProjectServiceImplementation implements ProjectService{

    private ProjectRepository projectRepo;

    @Autowired
    public ProjectServiceImplementation(ProjectRepository projectRepo){
        this.projectRepo = projectRepo;
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

}
