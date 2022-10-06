package com.fan.mvcdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fan.mvcdemo.models.Donation;
import com.fan.mvcdemo.services.DonationService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	public final DonationService donationServ;
	public ApiController(DonationService donationServ) {
		this.donationServ = donationServ;
	}
	
//	@GetMapping("/donations")
//	public List<Donation> findAllDonations(){
//		return this.donationServ.findAll();
//	}
//	
//	@PostMapping("/donations")
//	public Donation createDonation(
//			@RequestParam("donationName")String donationName,
//			@RequestParam("donor")String donor,
//			@RequestParam("quantity")Integer quantity
//			) {
//		Donation donation = new Donation(donationName, donor, quantity);
//		return this.donationServ.create(donation);
//		
//	}
	
	@GetMapping("/donations/{id}")
	public Donation findOne(
			@PathVariable("id")Long id) {
		
		return this.donationServ.findOne(id);
	}
	
	@DeleteMapping("/donations/{id}")
	public String delete(@PathVariable("id")Long id) {
		this.donationServ.delete(id);
		return "/donations";
	}
	
//	@GetMapping("/donations/op/{id}")
//	public Optional<Donation> findOneOp(
//			@PathVariable("id")Long id) {
//		
//		return this.donationServ.findOneOp(id);
//	}
	//-----------Edit-------------
//	@PutMapping("/donations/{id}")
//	public Donation editOneDonation(
//			@PathVariable("id")Long id,
//			@RequestParam("donationName")String donationName,
//			@RequestParam("donor")String donor,
//			@RequestParam("quantity")Integer quantity
//			) {
//		Donation donation = this.findOne(id);
//		donation.setDonationName(donationName);
//		donation.setDonor(donor);
//		donation.setQuantity(quantity);
//		
//		return this.donationServ.create(donation);
//	}

}
