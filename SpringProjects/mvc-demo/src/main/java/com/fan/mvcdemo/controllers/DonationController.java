package com.fan.mvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fan.mvcdemo.services.DonationService;

@Controller
@RequestMapping("/donation")
public class DonationController {
	private final DonationService donationServ;
	public DonationController(DonationService donationServ) {
		// TODO Auto-generated constructor stub
		this.donationServ = donationServ;
	}
	
	@GetMapping("/all")
	public String showAllDonation(Model model) {
		model.addAttribute("allDonation", this.donationServ.findAll());
		return "donation/showAll.jsp";
	}
	
	@GetMapping("/show/{id}")
	public String showOneDonation(
			@PathVariable("id") Long id,
			Model model) {
		model.addAttribute("donation", this.donationServ.findOne(id));
		return "donation/showOne.jsp";
	}

}
