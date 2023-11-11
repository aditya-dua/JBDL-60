package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.model.CreateEmployeeRequestModel;
import com.example.demo.model.CreateEmployeeResponseModel;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@PostMapping("/create")
	public CreateEmployeeResponseModel createEmployee(@RequestBody CreateEmployeeRequestModel empReq) {
		
		return empService.createEmployee(empReq);
	
	}
	
	/*public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}*/
	
	@GetMapping("/get/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return empService.getEmployee(id);
	}
	
	@GetMapping("/getWithStatus/{id}")
	public ResponseEntity<Employee> getEmployeeWithStatus(@PathVariable int id) {
		return empService.getEmployeeWithStatus(id);
	}
	
	/*
	 * Add the following functionalities:
	 * 1. Get All Employees
	 * 2. Delete an Employee on the basis of ID
	 * 3. Update an Employee on the basis of ID
	 * 4. Get Employee on the basis of Name
	 */
	
	
	
	
}
