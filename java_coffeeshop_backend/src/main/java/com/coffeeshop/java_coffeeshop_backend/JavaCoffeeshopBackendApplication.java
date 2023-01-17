package com.coffeeshop.java_coffeeshop_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class JavaCoffeeshopBackendApplication {
	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(JavaCoffeeshopBackendApplication.class, args);
	}

	@GetMapping("/products")
	public Iterable<Product> index() {
		return productRepository.findAll();
	}

	@PostMapping("/products")
	public Iterable<Product> create (@RequestBody Product productData) {
		productRepository.save(productData);
		return productRepository.findAll();
	}

	@DeleteMapping("/products/{id}")
	public Iterable<Product> delete(@PathVariable int id) {
		productRepository.deleteById(id);
		return productRepository.findAll();
	}

	@PutMapping("/products/{id}")
	public Iterable<Product> update(@PathVariable int id, @RequestBody Product productData) {
		productData.setId(id);
		productRepository.save(productData);
		return productRepository.findAll();
	}

}

