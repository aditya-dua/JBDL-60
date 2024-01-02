package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;
import com.example.demo.repositories.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	public void createAuthor(Author author) {
		authorRepository.save(author);
		
	}
	
	public void updateAuthor(Author author) {
		authorRepository.updateAuthorDetails(author);
		
	}
	
	public void deleteAuthor(int id) {
		authorRepository.deleteCustom(id);
		
	}
	
	public Optional<Author> findById(int id) {
		return authorRepository.findById(id);
		
	}

}
