package com.fan.fruityloop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fan.fruityloop.models.Fruit;
import com.fan.fruityloop.models.Store;

@Controller
public class HomeController {

	@GetMapping("")
	public String store(Model model) {
		Store fruitStore = new Store();
		fruitStore.getItems().add(new Fruit("Kiwi", 1.5));
		fruitStore.getItems().add(new Fruit("Mango", 2.0));
		fruitStore.getItems().add(new Fruit("Goji Berries", 4.0));
		fruitStore.getItems().add(new Fruit("Guava", .75));
		
		model.addAttribute("fruits", fruitStore.getItems());
		
		return "index.jsp";
	}
}
