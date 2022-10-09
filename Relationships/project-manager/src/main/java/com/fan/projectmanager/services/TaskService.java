package com.fan.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fan.projectmanager.models.Task;
import com.fan.projectmanager.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;
    
    public Task create(Task task) {
        return this.taskRepo.save(task);
    }
    
    public List<Task> findAll(){
        return this.taskRepo.findAll();
    }
    
    public Task findTask(Long task_id) {
        Optional<Task> task = this.taskRepo.findById(task_id);
        return task.isPresent()?task.get():null;
    }
    
}
