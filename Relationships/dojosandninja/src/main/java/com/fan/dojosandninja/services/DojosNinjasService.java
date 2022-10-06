package com.fan.dojosandninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fan.dojosandninja.models.Dojo;
import com.fan.dojosandninja.models.Ninja;
import com.fan.dojosandninja.repositories.DojoRepository;
import com.fan.dojosandninja.repositories.NinjaRepository;

@Service
public class DojosNinjasService {
	private DojoRepository dojoRepo;
	private NinjaRepository ninjaRepo;
	
	public DojosNinjasService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		super();
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	public Ninja getOneNinja(Long ninjaId) {
		Optional<Ninja> ninja = this.ninjaRepo.findById(ninjaId);
		return ninja.isPresent() ? ninja.get() : null;
	}
	
	public Dojo getOneDojo(Long dojoId) {
		Optional<Dojo> dojo = this.dojoRepo.findById(dojoId);
		return dojo.isPresent() ? dojo.get() : null;
	}
	
	public List<Dojo> getAllDojo() {
		return this.dojoRepo.findAll();
	}
	
	public List<Ninja> getAllNinja() {
		return this.ninjaRepo.findAll();
	}
	
	

}
