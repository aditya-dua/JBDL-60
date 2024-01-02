package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;
	
	// Ideally the Request body should be a model, so that you can get the relation you need
	
	
	@PostMapping("/create")
	public ResponseEntity createBook(@RequestBody Book book) {
		if(book == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}else if(book.getAuthor().getId()>0){
			authorService.createAuthor(book.getAuthor());
			// you have to call the Logic to create the author
			
		}
		
		bookService.createBook(book);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/all")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/get/available")
	public ResponseEntity getAvailableBooks(@RequestParam(value="genre", required=false) String genre, 
										@RequestParam(value="available", required=false,defaultValue="false") boolean available,
										@RequestParam(value="author", required=false) String author ){
		
		List<Book> bookList = bookService.getBooks(genre, available, author);
		
		
		return new ResponseEntity(bookList, HttpStatus.OK);
	}
	
	/**
	 * There are 2 ways to prefill the data for testing:
	 * 1. You simply call the API's first create the book, then create the author, you update the book by adding the author
	 * 2. You simply go the database and pre fill the data, you insert book, author and student and check if the get Calls are working
	 * 
	 */
	
}
