package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Value("${books.fine_per_day}")
	int fine_per_day;
	
	
	public void createBook(Book book) {
		bookRepository.save(book);
	}
	
	

}
