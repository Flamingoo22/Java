package com.fan.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fan.projectmanager.models.Project;
import com.fan.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
    
    List<Project> findAll();
    List<Project> findByUsersNotContains(User user);
    List<Project> findByUsersContains(User user);
    List<Project> findByLeadUserIs(User lead);
}
