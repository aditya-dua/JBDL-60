package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public long getTotalCount() {
		return studentRepo.count();
	}
	
	public Student getStudent(int id) {
		return studentRepo.getById(id);
		//return studentRepo.fin
	}
	
	public Student getStudent(String name) {
		return studentRepo.findByName(name);
		//return studentRepo.fin
	}
	
	
}
