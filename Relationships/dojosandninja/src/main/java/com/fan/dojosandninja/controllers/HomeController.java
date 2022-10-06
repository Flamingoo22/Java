package com.fan.dojosandninja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fan.dojosandninja.models.Dojo;
import com.fan.dojosandninja.models.Ninja;
import com.fan.dojosandninja.services.DojosNinjasService;

@Controller
public class HomeController {
	
	private DojosNinjasService service;
	
	public HomeController(DojosNinjasService service) {
		this.service = service;
	}
	
	@GetMapping("dojos/new")
	public String dojo(
			@ModelAttribute("dojo")Dojo dojo
			) {
		return "dojos/new.jsp";
	}
	@GetMapping("ninjas/new")
	public String ninja(
			@ModelAttribute("ninjas")Ninja ninja,
			Model model
			) {
		model.addAttribute("dojos", this.service.getAllDojo());
		return "ninjas/new.jsp";
	}
	
	@PostMapping("dojos/new")
	public String createDojo(
			@Valid @ModelAttribute("dojo")Dojo dojo,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "dojos/new.jsp";
		}
		this.service.createDojo(dojo);
		return "redirect:/dojos/" + dojo.getId();
	}
	
	@PostMapping("ninjas/new")
	public String createNinja(
			@Valid @ModelAttribute("ninja")Ninja ninja,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "ninjas/new.jsp";
		}
		this.service.createNinja(ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}
	
	@GetMapping("dojos/{dojo_id}")
	public String showDojo(
			@PathVariable("dojo_id")Long dojo_id,
			Model model
			) {
		model.addAttribute("dojo", this.service.getOneDojo(dojo_id));
		return "dojos/show.jsp";
	}
	
}
