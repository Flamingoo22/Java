package com.fan.mvcdemo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fan.mvcdemo.models.Donation;
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
	
//	@GetMapping("/new")
//	public String newDonation() {
//		return "donation/createForm.jsp";
//	}
//	
//	@PostMapping("/new")
//	public String processNewDonation(
//			@RequestParam("donationName")String donationName,
//			@RequestParam("donor")String donor,
//			@RequestParam("quantity")Integer quantity
//			) {
//		Donation donation = new Donation(donationName, donor, quantity);
//		this.donationServ.create(donation);
//		return "redirect:/donation/all";
//	}
	
	@GetMapping("/new")
	public String newDonation(
			Model model
//			@ModelAttribute("donation") Donation donation
			) {
		model.addAttribute("donation", new Donation());
		return "donation/createForm.jsp";
	}
	
	@PostMapping("/new")
	public String processNewDonation(
			@Valid @ModelAttribute("donation") Donation donation,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "donation/createForm.jsp";
		}
		this.donationServ.create(donation);
		return "redirect:/donation/all";
	}
	
	@GetMapping("/edit/{id}")
	public String editDonation(
			@PathVariable("id") Long id,
			Model model
			) {
		Donation donation = this.donationServ.findOne(id);
		model.addAttribute("donation",donation);
		return "donation/editForm.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String processEditDonation(
			@Valid @ModelAttribute("donation") Donation donation,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "donation/editForm.jsp";
		}
		this.donationServ.create(donation);
		return "redirect:/donation/all";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDonation(
			@PathVariable("id")Long id
			) {
		this.donationServ.delete(id);
		return "redirect:/donation/all";
	}
}
