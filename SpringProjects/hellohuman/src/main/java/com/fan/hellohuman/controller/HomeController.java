package com.fan.hellohuman.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required = false)String name
						, @RequestParam(value = "last_name", required = false)String lastname
						, @RequestParam(value = "times", required = false)Integer times) {
		if (name == null) {
			return "Hello Human";
		}
		else if (lastname==null && times == null) {
			return "Hello " + name; 
		}
		else if(times == null) {
			return "Hello " + name + " " + lastname;
		}
		else if(lastname == null) {
			String message = "";
			for (int i = 0; i< times; i++) {
			message += "Hello "+name;	
		}
			return message;
			
		}else {
			String message = "";
			for (int i = 0; i< times; i++) {
			String m = String.format("Hello %s %s ", name, lastname);
			message += m;
			}
			return message;
		}
	}
}
