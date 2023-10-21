package com.example.demo.service;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Employee;
import com.example.demo.model.CreateEmployeeRequestModel;
import com.example.demo.model.CreateEmployeeResponseModel;

@Service
public class EmployeeService {
	
	HashMap<Integer, Employee> empHM = new HashMap<Integer, Employee>();
	
	Employee emp;
	
	public CreateEmployeeResponseModel createEmployee(@RequestBody CreateEmployeeRequestModel empReq) {
		
		int base= empReq.getSal()*2;
		
		emp = new Employee(empReq.getId(), empReq.getName(), empReq.getSal(), empReq.getEmail(),base);
		empHM.put(emp.getId(), emp);
		
		CreateEmployeeResponseModel response = new CreateEmployeeResponseModel(emp.getId(), emp.getName(), emp.getSal(), emp.getEmail());
		
		return response;
		
	}
	
	/*
	 * public List<Employee> getAllEmployees(){
	 
		
		// To-Do:
		// Using The Entry Set, get all Keys and then get all the values of thos ekeys and insert them into an array.
		
		 
		
	}*/
	
	public Employee getEmployee( int id) {
		return empHM.get(id);
	}
	
	public ResponseEntity<Employee> getEmployeeWithStatus( int id) {
		
		if(empHM.containsKey(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(empHM.get(id));
		}else {
			return ResponseEntity.badRequest().body(empHM.get(1));
		}
		
		//return empHM.get(id);
	}

}
