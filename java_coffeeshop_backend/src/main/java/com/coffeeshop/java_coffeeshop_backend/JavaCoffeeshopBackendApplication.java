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
	private ProductsRepository productsRepository;
	public static void main(String[] args) {
		SpringApplication.run(JavaCoffeeshopBackendApplication.class, args);
	}
	@GetMapping("/products")
	public Iterable<Products> index() {
		return productsRepository.findAll();
	}

	@PostMapping("/products")
	public Iterable<Products> create (@RequestBody Products productData) {
		productsRepository.save(productData);
		return productsRepository.findAll();
	}

	@DeleteMapping("/products/{id}")
	public Iterable<Products> delete(@PathVariable int id) {
		productsRepository.deleteById(id);
		return productsRepository.findAll();
	}

	@PutMapping("/products/{id}")
	public Iterable<Products> update(@PathVariable int id, @RequestBody Products productsData) {
		productsData.setId(id);
		productsRepository.save(productsData);
		return productsRepository.findAll();
	}

}

