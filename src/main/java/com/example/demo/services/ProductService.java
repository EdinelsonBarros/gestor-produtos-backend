package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.product.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	public Product saveProduct(Product p) {
		repository.save(p);
		return p;
	}
	
	public List<Product> findAll(Product p) {
		return repository.findAll();
	}
	
	public Product updateProduct(Product p) {
		return p;
	}
	public void deleteProduct(String id) {
		var productExist = repository.findById(id);
		
		
			repository.delete(productExist.get());
		
		
		
	}
}
