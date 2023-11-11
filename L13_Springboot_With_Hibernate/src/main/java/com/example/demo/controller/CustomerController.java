package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CreateCustomerRequestModel;
import com.example.demo.model.CreateCustomerResponseModel;
import com.example.demo.model.GetCustomerResponseModel;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/test")
	public String testAPI() {
		return "Test API works!";
	}
	
	@PostMapping("/create")
	public CreateCustomerResponseModel createCustomer(@RequestBody CreateCustomerRequestModel customer) {
		return customerService.createCustomer(customer);
	}
	
	@GetMapping("/get/{id}")
	public GetCustomerResponseModel getEmployeeById(@PathVariable int id) {
		return customerService.getEmployeeById(id);
	}
	
	// Add another function using which you can get all the customers.
}
