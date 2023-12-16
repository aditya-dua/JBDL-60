package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class L19SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(L19SpringSecurityApplication.class, args);
	}
	
	@GetMapping("/test")
	public String test() {
		return "Test API works";
	}
	
	@GetMapping("/user/test")
	public String userTest() {
		return "User Test API works";
	}
	
	@GetMapping("/home/test")
	public String homeTest() {
		return "Home Test API works";
	}

}
