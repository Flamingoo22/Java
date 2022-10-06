package com.fan.relationshipDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fan.relationshipDemo.models.Person;
import com.fan.relationshipDemo.repositories.PersonRepo;


@Service
public class PersonService {
	private PersonRepo personRepo;

	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
	public Person findPerson(Long id) {
		Optional<Person> person = this.personRepo.findById(id);
		return person.isPresent()?person.get():null;
	}
	
	public Person create(Person person) {
		return this.personRepo.save(person);
	}
	
	public List<Person> findAll(){
		return this.personRepo.findAll();
	}
}
