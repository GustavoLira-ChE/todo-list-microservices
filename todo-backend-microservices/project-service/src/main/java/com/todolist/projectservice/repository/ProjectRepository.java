package com.todolist.projectservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todolist.projectservice.model.ProjectEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

    @Query(value = "select * from projects where user_id = ?1", nativeQuery = true)
    public abstract List<ProjectEntity> findAllByUserId(int userId);
    
}
