package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;

import jakarta.transaction.Transactional;

@Transactional
public interface AuthorRepository extends JpaRepository<Author, Integer>{

	// 2 functions... update author and other would be delete the author
	
	@Modifying
	@Query("update Author a set a.name=:#{#new_author.name},a.email=:#{#new_author.email}, a.age=:#{#new_author.age}, a.country=:#{#new_author.country} where a.id=:#{#new_author.id}")
	int updateAuthorDetails(@Param("new_author") Author new_author);
	@Modifying
	@Query("delete Author a where a.id=:given_id")
	int deleteCustom(@Param("given_id")int id);
	
	
}
