package com.todolist.taskservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todolist.taskservice.model.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {

    @Query(value = "select * from task where project_id = ?1", nativeQuery = true)
    public abstract List<TaskEntity> findAllByProjectId(int projectId);
    
}
