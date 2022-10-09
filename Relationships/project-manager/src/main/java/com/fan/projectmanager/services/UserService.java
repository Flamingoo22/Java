package com.fan.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.fan.projectmanager.models.LoginUser;
import com.fan.projectmanager.models.User;
import com.fan.projectmanager.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User findUserByEmail(String email) {
		Optional<User> user = this.userRepo.findByEmail(email);
		return user.isPresent()?user.get():null;
	}
	
	public User findUserById(Long user_id) {
		Optional<User> user = this.userRepo.findById(user_id);
		return user.isPresent()?user.get():null;
	}
	
	public List<User> findAll(){
		return this.userRepo.findAll();
	}

	public User create(User user) {
		return this.userRepo.save(user);
	}
	
	public User update(User user) {
	    return this.userRepo.save(user);
	}
	
	public User register(User newUser, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
        // TO-DO: Additional validations!
		if(this.findUserByEmail(newUser.getEmail())!= null) {
			result.rejectValue("email", "Matches", "Email already taken.");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		if(result.hasErrors()) {
			return null;
		}
		newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
        return newUser;
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
    	if(result.hasErrors()) {
    		return null;
    	}
        // TO-DO: Additional validations!
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	if(this.findUserByEmail(newLoginObject.getEmail()) == null) {
    		result.rejectValue("password", "Matches", "Invalid Password!");
		}
    	else if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	User user = potentialUser.get();
        return user;
    }
}