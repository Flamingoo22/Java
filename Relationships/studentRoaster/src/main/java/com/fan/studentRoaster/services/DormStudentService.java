package com.fan.studentRoaster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fan.studentRoaster.models.Dorm;
import com.fan.studentRoaster.models.Student;
import com.fan.studentRoaster.repositories.DormRepository;
import com.fan.studentRoaster.repositories.StudentRepository;

@Service
public class DormStudentService {
	private DormRepository dormRepo;
	private StudentRepository studentRepo;
	
	public DormStudentService(DormRepository dormRepo, StudentRepository studentRepo) {
		this.dormRepo = dormRepo;
		this.studentRepo = studentRepo;
	}
	
	public Dorm createDorm(Dorm dorm) {
		return this.dormRepo.save(dorm);
	}
	
	public Student createStudent(Student student) {
		return this.studentRepo.save(student);
	}
	
	public Dorm findDorm(Long dorm_id) {
		Optional<Dorm>dorm = this.dormRepo.findById(dorm_id);
		return dorm.isPresent() ? dorm.get() : null;
	}
	
	public Student findStudent(Long student_id) {
		Optional<Student>student = this.studentRepo.findById(student_id);
		return student.isPresent()? student.get():null;
	}

	public List<Dorm> findAllDorm(){
		return this.dormRepo.findAll();
	}
	
	public List<Student> findAllStudent(){
		return this.studentRepo.findAll();
	}
	
	public Student changeDorm(Student student) {
		return this.studentRepo.save(student);
	}
	
	public void deleteDorm(Long dorm_id) {
		this.dormRepo.deleteById(dorm_id);
	}
}
