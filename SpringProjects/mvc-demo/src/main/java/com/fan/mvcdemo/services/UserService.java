package com.fan.mvcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fan.mvcdemo.models.User;
import com.fan.mvcdemo.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	public UserService(UserRepository userRepo) {
		// TODO Auto-generated constructor stub
		this.userRepo = userRepo;
	}
	
	//find all
	public List<User> findAll(){
		return userRepo.findAll();
	}
	//get one by id
	public User getUser(Long id) {
		Optional<User> potentialUser = userRepo.findById(id);
		return potentialUser.isPresent() ? potentialUser.get() : null;
	}
	//get one by email
	public User getUser(String email) {
		Optional<User>optionalUser = userRepo.findByEmail(email);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}
	//create
	public User create(User user) {
		return userRepo.save(user);
	}

}
