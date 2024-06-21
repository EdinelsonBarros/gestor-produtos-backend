package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductReponseDTO;
import com.example.demo.domain.product.ProductRequestDTO;
import com.example.demo.repositories.ProductRepository;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody @Validated ProductRequestDTO p) {
		Product newProduct = new Product(p.productName(), p.costPrice(), p.salePrice());
		productRepository.save(newProduct);
		return newProduct;
	}

}
