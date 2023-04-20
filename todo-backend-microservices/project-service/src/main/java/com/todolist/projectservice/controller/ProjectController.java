package com.todolist.projectservice.controller;

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

import com.todolist.projectservice.model.ProjectEntity;
import com.todolist.projectservice.service.ProjectService;

@RestController
@RequestMapping()
public class ProjectController {
    
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectEntity>> findAll() {
        Optional<List<ProjectEntity>> projects = Optional.of(this.projectService.findAll());
        if(projects.isPresent()){
            return ResponseEntity.ok(this.projectService.findAll());
        } else {
            return new ResponseEntity<List<ProjectEntity>>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProjectEntity> findById(@PathVariable(name = "id") int projectId){
        ProjectEntity project;
        if(this.projectService.findById(projectId).isPresent()){
            project = this.projectService.findById(projectId).get();
            return ResponseEntity.ok(project);
        } else {
            return new ResponseEntity<ProjectEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ProjectEntity> save(@RequestBody ProjectEntity project) {
        try{
            ProjectEntity newProject = this.projectService.save(project);
            return ResponseEntity.ok(newProject);
        } catch(Exception e) {
            return new ResponseEntity<ProjectEntity>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") int projectId){
        if(this.projectService.findById(projectId).isPresent()){
            this.projectService.deleteById(projectId);
            return ResponseEntity.ok(true);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/user-id/{id}")
    public ResponseEntity<List<ProjectEntity>> findByUser_id(@PathVariable(name = "id") int userId){
        Optional<List<ProjectEntity>> projects = Optional.of(this.projectService.findAllByUser_id(userId));
        if(projects.isPresent()){
            return ResponseEntity.ok(projects.get());
        } else {
            return new ResponseEntity<List<ProjectEntity>>(HttpStatus.NO_CONTENT);
        }
    }

}
