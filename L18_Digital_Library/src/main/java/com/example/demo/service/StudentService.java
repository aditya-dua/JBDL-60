package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Card;
import com.example.demo.entity.Student;
import com.example.demo.repositories.CardRepository;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	CardService cardService;
	
	public String createStudent(Student student) {
		studentRepo.save(student);
		Card card = cardService.createCard(student);
		return "Success";
		
	}

}
