package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@RestController
public class UserController {

	
	private final UserRepo userRepo;
	
	@Autowired
	public UserController(UserRepo user) {
		// TODO Auto-generated constructor stub
		this.userRepo = user;
	}
	
	@RequestMapping("/load")
	public String load() {
		
		User aditya = new User(1, "Aditya", 10000);
		User john = new User(2, "John", 12000);
		User david = new User(3, "David", 5000);
		
		userRepo.save(aditya);
		userRepo.save(john);
		userRepo.save(david);
		return "Repo Count:"+userRepo.count();
	}
	
	@RequestMapping("/test")
	public String test() {return "Test Works";}
	
	@RequestMapping("/get/{userId}")
	@Cacheable(value = "jbdl-60-users", key="#userId")
	public Optional<User> getUser(@PathVariable int userId){
		return userRepo.findById(userId);
	}
	
	
	@RequestMapping("/delete/{userId}")
	@CacheEvict(value = "jbdl-60-users",key="#userId")
	public String deleteUser(@PathVariable int userId){
		 userRepo.deleteById(Integer.valueOf(userId));
		 return "Success";
	}
	
}
