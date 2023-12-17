package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class ProductInitializer implements CommandLineRunner {

    private final ItemRepo repo;

    ProductInitializer(ItemRepo repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Nike","ADIDAS", "PUMA")
                .forEach(i -> repo.save(new Product(i)));

        repo.findAll().forEach(System.out::println);
    }
}