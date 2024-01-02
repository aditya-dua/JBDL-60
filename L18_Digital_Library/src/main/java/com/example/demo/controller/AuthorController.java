package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@PostMapping("/create")
	public ResponseEntity createAuthor(@RequestBody Author author) {
		authorService.createAuthor(author);
		return new ResponseEntity("Author Created", HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity updateAuthor(@RequestBody Author author) {
		authorService.updateAuthor(author);
		return new ResponseEntity("Author Updated!", HttpStatus.OK);
	}
	

	@DeleteMapping("/delete")
	public ResponseEntity deleteAuthor(@RequestParam("id") int id) {
		authorService.deleteAuthor(id);
		return new ResponseEntity("Author Deleted!", HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity get(@RequestParam("id") int id) {
		Optional<Author> a = authorService.findById(id);
		return new ResponseEntity(a.get(), HttpStatus.OK);
	}
	
	
	
	/**
	 * There are 2 ways to prefill the data for testing:
	 * 1. You simply call the API's first create the book, then create the author, you update the book by adding the author
	 * 2. You simply go the database and pre fill the data, you insert book, author and student and check if the get Calls are working
	 * 
	 */
	
}
