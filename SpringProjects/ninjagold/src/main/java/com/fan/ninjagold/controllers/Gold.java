package com.fan.ninjagold.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Gold {
	
	@GetMapping("/gold")
	public String gold(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {			

			session.setAttribute("gold", 0);

		}else {
			if ((int)session.getAttribute("gold") < -500) {
				return "prison.jsp";
			}
			session.getAttribute("gold");
		}
		return "gold.jsp";
	}
	
	@PostMapping("/process_money")
	public String earn(
			@RequestParam(value="name")String choice,
			HttpSession session) {
		
		Random rand = new Random();
		int farm = rand.nextInt(31)+10;
		int cave = rand.nextInt(21)+10;
		int house = rand.nextInt(11)+10;
		int quest = rand.nextInt(201)-100;
		int spa = rand.nextInt(20)+5;
		spa *= -1;
		

		HashMap<String, Integer> gold = new HashMap<String, Integer>();
		gold.put("farm",farm);
		gold.put("cave",cave);
		gold.put("house",house);
		gold.put("quest",quest);
		gold.put("spa",spa);
		
		int earn = gold.get(choice);
		int amount = (int)session.getAttribute("gold");
		session.setAttribute("gold", earn + amount);
		String message;
		
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yy HH:mm:ss");  
		String strDate = dateFormat.format(date);  
		
		if(earn>0) {
			message = String.format("<span style=\"margin:-4px 0px; color:green\">You entered a %s and earned %d gold.  %s</span> <br>", choice, earn, strDate);			
		}else {
			message = String.format("<span style=\"margin:-4px 0px; color:red\">You entered a %s and lost %d gold.  %s</span> <br>", choice, earn, strDate);
		}
		
		if(session.getAttribute("message")==null) {
			session.setAttribute("message", message);			
		}
		else {
			String prevMessages = (String) session.getAttribute("message");
			session.setAttribute("message",message += prevMessages );
		}
		System.out.println(earn);
		return ("redirect:/gold");
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", 0);
		session.setAttribute("message", "");
		return "redirect:/gold";
	}
}
