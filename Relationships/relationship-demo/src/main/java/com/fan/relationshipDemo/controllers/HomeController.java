package com.fan.relationshipDemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fan.relationshipDemo.models.License;
import com.fan.relationshipDemo.models.Person;
import com.fan.relationshipDemo.services.LicenseService;
import com.fan.relationshipDemo.services.PersonService;

@Controller
public class HomeController {
	private PersonService personService;
	private LicenseService licenseService;
	
	
	
	public HomeController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}

	@GetMapping("/persons/{person_id}")
	public String showPerson(@PathVariable Long person_id, Model model) {
	    
	    Person someAwesomePerson = personService.findPerson(person_id);
	    model.addAttribute("person", someAwesomePerson);
	    
	    return "/person/show.jsp";
	}
	
	@GetMapping("/dashboard")
	public String showAll( Model model) {
		List<Person> persons = this.personService.findAll();
		System.out.println(persons);
		model.addAttribute("persons", persons);
		return "dashboard.jsp";
	}
	
//	@GetMapping("/persons/{id}")
//	public String showPerson1(
//			@PathVariable("id")Long id,
//			Model model
//			) {
//		Person person = this.personService.findPerson(id);
//		model.addAttribute("person", person);
//		return "/person/show.jsp";
//	}
	
	
	@GetMapping("/persons")
	public String createPerson(
			@ModelAttribute("person")Person person
			) {
		return "/person/new.jsp";
	}
	
	@GetMapping("/license")
	public String createLicense(
			@ModelAttribute("license")License license,
			Model model
			) {
		model.addAttribute("persons", this.personService.findAll());
		return "/license/new.jsp";
	}
	
	
	@PostMapping("/license")
	public String licenses(
			@Valid @ModelAttribute("license") License license,
			BindingResult result
			) {
		if (result.hasErrors()) {
            return "/license/new.jsp";
		}
	    licenseService.create(license); // Already has the person!
	        
	    return "redirect:/persons/"+license.getPerson().getId();
	}
	
	
	@PostMapping("/persons")
	public String persons(
			@Valid @ModelAttribute("person") Person person,
			BindingResult result
			) {
		if (result.hasErrors()) {
            return "/person/new.jsp";
		}
	    this.personService.create(person);
	    return "redirect:/persons/"+person.getId();
	}
	

}
