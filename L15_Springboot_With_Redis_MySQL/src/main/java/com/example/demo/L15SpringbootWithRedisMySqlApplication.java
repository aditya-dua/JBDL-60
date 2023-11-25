package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class L15SpringbootWithRedisMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(L15SpringbootWithRedisMySqlApplication.class, args);
	}

}
