package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
@Entity
@NoArgsConstructor

public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	public Product(String name) {
		this.name = name;
	}

}
