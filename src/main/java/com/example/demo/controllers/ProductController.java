package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductDeleteDTO;
import com.example.demo.domain.product.ProductReponseDTO;
import com.example.demo.domain.product.ProductRequestDTO;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/create")
	public ResponseEntity createProduct(@RequestBody @Valid ProductRequestDTO p) {
		Product newProduct = new Product(p.productName(), p.costPrice(), p.salePrice());
		productRepository.save(newProduct);
		return ResponseEntity.ok(new ProductReponseDTO(newProduct));
	}
	
	@GetMapping("/findall")
	public ResponseEntity findAllProduct() {
		List<ProductReponseDTO> products = productRepository.findAll().stream().map(ProductReponseDTO::new).toList();
		System.out.println(products);
		return ResponseEntity.ok(products);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteProductById(@PathVariable("id") String id) {
		
		productRepository.deleteById(id);
		return ResponseEntity.ok("Produto deletado");
	}

}
