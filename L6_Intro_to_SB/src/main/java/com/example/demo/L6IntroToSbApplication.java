package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class L6IntroToSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(L6IntroToSbApplication.class, args);
	}
	
	@RequestMapping("/")
	public String test() {
		System.out.println("API request recieved");
		return "Test API Works!";
	}
	
	@RequestMapping("/greet")
	public String greeting(@RequestParam String name) {
		String msg = "";
		if(name ==null ||name.equals("") ) {
			msg = "Hello World!";
			
		}else {
			msg = "Hello "+name;
		}
		return msg;
	}
	
	@RequestMapping("/greet/{name}")
	public String testFunc(@PathVariable String name) {
		return "Hello From testFunc with "+name;
	}

}
