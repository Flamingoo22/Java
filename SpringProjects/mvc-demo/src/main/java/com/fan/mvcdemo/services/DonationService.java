package com.fan.mvcdemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fan.mvcdemo.models.Donation;
import com.fan.mvcdemo.repositories.DonationRepo;


@Service
public class DonationService {
	private final DonationRepo donationRepo;
	public DonationService(DonationRepo donationRepo) {
		// TODO Auto-generated constructor stub
		this.donationRepo = donationRepo;
	}
	
	public List<Donation> findAll(){
		return this.donationRepo.findAll();
	}
	
	public Donation create(Donation donation) {
		return this.donationRepo.save(donation);
	}
	
	public Donation findOne(Long id) {
		return this.donationRepo.findById(id).isPresent() ? this.donationRepo.findById(id).get() : null; //tenary
//		Optional<Donation> donation = this.donationRepo.findById(id);
//		if(donation.isPresent()) return donation.get();
//		return null;
	}
	
//	public Optional<Donation> findOneOp(Long id) {
//		Optional<Donation> donation = this.donationRepo.findById(id);
//		if(donation.isPresent()) return donation;
//		return null;
//	}
	
	public void delete(Long id) {
		this.donationRepo.deleteById(id);
	}


}
