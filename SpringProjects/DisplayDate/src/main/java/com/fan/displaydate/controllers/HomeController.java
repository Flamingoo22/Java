package com.fan.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String date() {
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String time() {
		return "time.jsp";
	}
	
	

}
