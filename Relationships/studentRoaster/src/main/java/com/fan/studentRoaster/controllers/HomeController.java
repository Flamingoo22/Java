package com.fan.studentRoaster.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.fan.studentRoaster.models.Dorm;
import com.fan.studentRoaster.models.Student;
import com.fan.studentRoaster.services.DormStudentService;

@Controller
public class HomeController {
	private DormStudentService service;

	public HomeController(DormStudentService service) {
		this.service = service;
	}
	
	@GetMapping("/dorms")
	public String allDorms(
			Model model
			) {
		model.addAttribute("dorms", this.service.findAllDorm());
		return "dorms/showAll.jsp";
	}
	
	@GetMapping("/dorms/new")
	public String addDorm(
			@ModelAttribute("dorm")Dorm dorm
			) {
		return "dorms/new.jsp";
	}
	
	@GetMapping("/students/new")
	public String addStudent(
			@ModelAttribute("student")Student student,
			Model model
			) {
		model.addAttribute("dorms", this.service.findAllDorm());
		return "students/new.jsp";
	}
	
	
	@PostMapping("/dorms/new")
	public String processAddDorm(
			@Valid @ModelAttribute("dorm")Dorm dorm,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "dorms/new.jsp";
		}
		this.service.createDorm(dorm);
		return "redirect:/dorms";		
	}
	
	@PostMapping("/students/new")
	public String processAddStudent(
			@Valid @ModelAttribute("student")Student student,
			BindingResult result) {
		if(result.hasErrors()) {
			return "student/new.jsp";
		}
		this.service.createStudent(student);
		return "redirect:/dorms";
	}
	
	@PutMapping("dorm/{dorm_id}/a")
	public String updateStudentDorm(
			@PathVariable("dorm_id")Long dorm_id,
			@RequestParam("students")Long student_id
			) {
		Dorm dorm = this.service.findDorm(dorm_id);
		List<Student> dormExistingStudents = dorm.getStudents();
		dormExistingStudents.add(this.service.findStudent(student_id));
		Student student = this.service.findStudent(student_id);
		student.setDorm(dorm);
		this.service.changeDorm(student);
		this.service.createDorm(dorm);
		return "redirect:/dorm/"+dorm_id;
	}
	
	@GetMapping("/dorm/{dorm_id}")
	public String showDorm(
			@PathVariable("dorm_id")Long dorm_id,
			Model model
			) {
		model.addAttribute("students", this.service.findAllStudent());
		model.addAttribute("dorm",this.service.findDorm(dorm_id));
		return "dorms/showOne.jsp";
	}
	
	@PutMapping("/dorm/{dorm_id}")
	public String removeStudent(
			@PathVariable("dorm_id")Long dorm_id,
			@RequestParam("student_id")Long student_id
			) {
		Student student = this.service.findStudent(student_id);
		student.setDorm(null);
		this.service.changeDorm(student);
		return "redirect:/dorm/"+ dorm_id;
	}
	
	
	@DeleteMapping("/dorm/{dorm_id}")
	public String removeDorm(
			@PathVariable("dorm_id")Long dorm_id
			) {
		this.service.deleteDorm(dorm_id);
		return "redirect:/dorms";
		
	}
}
