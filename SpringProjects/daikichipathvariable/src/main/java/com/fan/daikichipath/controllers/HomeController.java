package com.fan.daikichipath.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class HomeController {

	@RequestMapping("/travel/{location}")
	public String showDestination(@PathVariable("location")String location) {
		String message = String.format("Congratulations! You will soon travel to %s!", location);
		return message;
	}
	
	@RequestMapping("/lotto/{num}")
	public String lottoMessage(@PathVariable("num")int lotto) {
		if (lotto % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
		
	}
}
