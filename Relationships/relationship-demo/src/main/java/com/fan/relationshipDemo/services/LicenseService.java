package com.fan.relationshipDemo.services;

import org.springframework.stereotype.Service;

import com.fan.relationshipDemo.models.License;
import com.fan.relationshipDemo.repositories.LicenseRepo;

@Service
public class LicenseService {
	private LicenseRepo licenseRepo;

	public LicenseService(LicenseRepo licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	public License create(License license) {
		return this.licenseRepo.save(license);
	}
}
