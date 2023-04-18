package com.todolist.projectservice.service;

import java.util.List;
import java.util.Optional;

import com.todolist.projectservice.model.ProjectEntity;

public interface ProjectService {
    
    List<ProjectEntity> findAll();
    Optional<ProjectEntity> findById(int porjectId);
    ProjectEntity save(ProjectEntity project);
    void deleteById(int projectId);
}
