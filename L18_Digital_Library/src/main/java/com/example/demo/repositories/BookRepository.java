package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

import jakarta.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer>{

	// Find book by Author
	
	@Query("select b from Book b where b.available=:isAvailable and b.author in (select a from Author a where a.name=:author)")
	List<Book> findBooksbyAuthor(@Param("author") String author, @Param("isAvailable") boolean isAvailable);
	
	@Query("select b from Book b where b.available=:isAvailable")
	List<Book> findBooksByAvailablity(@Param("isAvailable") boolean isAvailable);
	
}
