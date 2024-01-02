package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

import jakarta.transaction.Transactional;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
	
}
