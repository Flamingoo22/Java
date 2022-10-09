package com.fan.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fan.projectmanager.models.Project;
import com.fan.projectmanager.models.User;
import com.fan.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepo;
    
    public Project findById(Long project_id) {
        Optional<Project> project = this.projectRepo.findById(project_id);
        return project.isPresent()?project.get():null;
    }
    
    public List<Project> findAll(){
        return this.projectRepo.findAll();
    }
    
    public List<Project> findMyLeadingProjects(User lead){
        return this.projectRepo.findByLeadUserIs(lead);
    }
    
    public List<Project> findMyProjects(User user){
        return this.projectRepo.findByUsersContains(user);
    }
    
    public List<Project> findNotMyProjects(User user){
        return this.projectRepo.findByUsersNotContains(user);
    }
    
    public Project create(Project project) {
        return this.projectRepo.save(project);
    }
    
    public Project updateProject(Project project) {
        return this.projectRepo.save(project);
    }
    
    public void deleteProject(Long project_id) {
        this.projectRepo.deleteById(project_id);
    }
}
