package com.fan.routessrpingdemo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String home(Model model) {
		int testint = 3;
		model.addAttribute("name","BOBBBBBY BROWN");
		model.addAttribute("number",testint);
		return "index.jsp";
	}
	
	@GetMapping("/jstl")
	public String jstl(Model model) {
		String name = "Bobby Brown";
		Integer age = 28;
		Boolean isHungry =true;
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("isHungry", isHungry);
		model.addAttribute("test", "<script>alert('h1')</script>");
		
		ArrayList<String> users = new ArrayList<String>();
		users.add("BOB");
		users.add("BOBBY");
		users.add("BOBROWN");
		users.add("BOBOY");
		users.add("BOBE");
		
		model.addAttribute("users", users);
		return "jstl.jsp";
	}
}
