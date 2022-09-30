package com.fan.routessrpingdemo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class RouterController {
	// query parameter: ...search?key=value
	// localhost:8080/search?key=value
	
	
	@RequestMapping("")
	public String searchKeyword(@RequestParam("keyword") String KeywordInMethod) {
		return "YOU ARE SEARCHING FOR " + KeywordInMethod;
	}
	
	@RequestMapping("/pet")
	public String getPet(@RequestParam("name") String name, @RequestParam("age") Integer age) {
		return "Your pet is "+name +" and is "+ age+ " years old.";
	}
	
	@RequestMapping("/optional/pet")
	public String getPetOptional(@RequestParam(value="name", required=false) String name, @RequestParam(value="age", required = false) Integer age) {
		return "Your pet is "+name +" and is "+ age+ " years old.";
	}
	
	@RequestMapping("/m/{name}/{color}")
	public String petWithColor(@PathVariable("name") String petName, @PathVariable("color") String color) {
		return petName + " is " + color;
	}
}
