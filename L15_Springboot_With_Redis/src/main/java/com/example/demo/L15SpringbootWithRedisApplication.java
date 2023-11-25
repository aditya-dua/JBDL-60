package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductDAORepo;

@SpringBootApplication
@RestController
public class L15SpringbootWithRedisApplication {

	@Autowired
	private ProductDAORepo dao;
	
	public static void main(String[] args) {
		SpringApplication.run(L15SpringbootWithRedisApplication.class, args);
	}
	
	@GetMapping("/test")
	public String test() {
		return "Get All Products";
	}
	
	@GetMapping("/")
	public List<Object> fetchProducts(){
		return dao.getAll();
	}
	
	@PostMapping("/")
	public Product save(@RequestBody Product product){
		return dao.save(product);
	}

}
