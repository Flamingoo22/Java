package com.fan.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fan.omikuji.models.Omikuji;

@Controller
@RequestMapping("/omikuji")
public class HomeController {
	
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String login(
			@RequestParam(value="number", required=false)Integer num,
			@RequestParam(value="location", required=false)String location,
			@RequestParam(value="person", required=false)String person,
			@RequestParam(value="hobby", required=false)String hobby,
			@RequestParam(value="thing", required=false)String thing,
			@RequestParam(value="message", required=false)String message,
			HttpSession session) {
		Omikuji sample = new Omikuji(num, location, person, hobby, thing, message);
		session.setAttribute("omikuji", sample);
		return "redirect:show";
	}
	
	@GetMapping("/show")
	public String display(HttpSession session) {
		session.getAttribute("omikuji");
		return "show.jsp";
	}
}
