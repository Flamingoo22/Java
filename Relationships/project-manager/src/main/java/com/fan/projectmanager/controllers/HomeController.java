package com.fan.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.fan.projectmanager.models.LoginUser;
import com.fan.projectmanager.models.Project;
import com.fan.projectmanager.models.Task;
import com.fan.projectmanager.models.User;
import com.fan.projectmanager.services.ProjectService;
import com.fan.projectmanager.services.TaskService;
import com.fan.projectmanager.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private ProjectService projectServ;
	
	@Autowired
	private TaskService taskServ;
	
    @GetMapping("")
    public String index(
            Model model,
            HttpSession session) {
        if(session.getAttribute("user_id") != null) {
            return "redirect:/dashboard";
        }
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result,
            Model model,
            HttpSession session) {
        this.userServ.register(newUser, result);
        if(result.hasErrors()) {

            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        this.userServ.create(newUser);
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result,
            Model model,
            HttpSession session) {
    	User user = this.userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/dashboard";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    @GetMapping("/dashboard")
    public String home(
            Model model,
            HttpSession session
            ) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        Long user_id = (Long) session.getAttribute("user_id");
        User user = this.userServ.findUserById(user_id);
        model.addAttribute("user", user);
        model.addAttribute("projects", this.projectServ.findNotMyProjects(user));
        return "home.jsp";
    }
    
    @PutMapping("/projects/{id}/join")
    public String join(
            @PathVariable("id")Long project_id,
            HttpSession session
            ) {
        Project projectdb = this.projectServ.findById(project_id);
        Long user_id = (Long) session.getAttribute("user_id");
        User user = this.userServ.findUserById(user_id);
        user.getProjects().add(projectdb);
        this.userServ.update(user);
        return "redirect:/dashboard";
    }
    
    @PutMapping("/projects/{id}/leave")
    public String leave(
            @PathVariable("id")Long project_id,
            HttpSession session
            ) {
        Project projectdb = this.projectServ.findById(project_id);
        Long user_id = (Long) session.getAttribute("user_id");
        User user = this.userServ.findUserById(user_id);
        user.getProjects().remove(projectdb);
        this.userServ.update(user);
        return "redirect:/dashboard";
    }
    
    @GetMapping("/projects/new")
    public String newProject(
            @ModelAttribute("project")Project project
            ) {
        return "/projects/new.jsp";
    }
    
    @DeleteMapping("/projects/{id}")
    public String deleteProject(
            @PathVariable("id")Long project_id
            ) {
        this.projectServ.deleteProject(project_id);
        return "redirect:/dashboard";
    }
    
    @PostMapping("/projects/new")
    public String newProject(
            @Valid @ModelAttribute("project")Project project,
            BindingResult result,
            Model model,
            HttpSession session
            ) {
        if(result.hasErrors()) {
            model.addAttribute("project", project);
            return "/projects/new.jsp";
        }
        Long user_id = (Long) session.getAttribute("user_id");
        User user = this.userServ.findUserById(user_id);
        project.setLeadUser(user);
        Project projectdb = this.projectServ.create(project);
        user.getProjects().add(projectdb);
        this.userServ.update(user);
        return "redirect:/dashboard";
    }
    
    @GetMapping("/projects/edit/{id}")
    public String editProject(
            @PathVariable("id")Long project_id,
            Model model
            ) {
        Project project = this.projectServ.findById(project_id);
        model.addAttribute("project",project);
        return "/projects/edit.jsp";
    }
    
    @PutMapping("/projects/edit/{id}")
    public String editProject(
            @Valid @ModelAttribute("project")Project project,
            BindingResult result,
            Model model,
            HttpSession session
            ) {
        if(result.hasErrors()) {
            model.addAttribute("project",project);
            return "/projects/edit.jsp";
        }
        Long user_id = (Long) session.getAttribute("user_id");
        User user = this.userServ.findUserById(user_id);
        project.setLeadUser(user);
        Project projectdb = this.projectServ.updateProject(project);
        user.getProjects().add(projectdb);
        this.userServ.update(user);
        return "redirect:/dashboard";
    }
    
    @GetMapping("/projects/{id}")
    public String showProject(
            @PathVariable("id")Long project_id,
            Model model
            ) {
        Project project = this.projectServ.findById(project_id);
        model.addAttribute("project", project);
        return "/projects/showOne.jsp";
    }
    
    @GetMapping("/projects/{id}/tasks")
    public String showTasks(
            @PathVariable("id")Long project_id,
            @ModelAttribute("task")Task task,
            Model model
            ) {
        Project project = this.projectServ.findById(project_id);
        model.addAttribute("project",project);
        model.addAttribute("tasks", project.getTasks());
        return "/tasks/new.jsp";
    }
    
    @PostMapping("/projects/{id}/tasks")
    public String createTask(
            @PathVariable("id")Long project_id,
            @Valid @ModelAttribute("task")Task task,
            BindingResult result,
            Model model,
            HttpSession session
            ) {
        if(result.hasErrors()) {
            model.addAttribute("task",task);
            return "/tasks/new.jsp";
        }
        Long user_id = (Long) session.getAttribute("user_id");
        User user = this.userServ.findUserById(user_id);
        Project project = this.projectServ.findById(project_id);
        task.setUser(user);
        task.setProject(project);
        Task taskdb = this.taskServ.create(task);
        project.getTasks().add(taskdb);
        this.projectServ.updateProject(project);
        
        return "redirect:/projects/"+project_id+"/tasks";
    }
    
}
