package com.fan.hopperrecipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fan.hopperrecipt.models.User;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        
    	User user1 = new User();
    	
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("user", user1);
        
        return "index.jsp";
    }
}
