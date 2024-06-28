package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductReponseDTO;
import com.example.demo.domain.product.ProductRequestDTO;
import com.example.demo.repositories.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/create")
	public ResponseEntity createProduct(@RequestBody @Valid ProductRequestDTO p) {
		Product newProduct = new Product(p.productName(), p.costPrice(), p.salePrice());
		productRepository.save(newProduct);
		return ResponseEntity.ok(new ProductReponseDTO(newProduct));
	}
	
	@GetMapping("/findall")
	public ResponseEntity findAllProduct() {
		List<ProductReponseDTO> products = productRepository.findAll().stream().map(ProductReponseDTO::new).toList();
		
		return ResponseEntity.ok(products);
	}

}
