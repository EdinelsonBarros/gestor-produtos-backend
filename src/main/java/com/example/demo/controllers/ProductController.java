	package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductDeleteDTO;
import com.example.demo.domain.product.ProductDTO;
import com.example.demo.domain.product.ProductRequestDTO;
import com.example.demo.domain.product.ProductResponseDTO;
import com.example.demo.domain.productCategory.ProductCategory;
import com.example.demo.repositories.ProductCategoryRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductCategoryRepository categoryRepository;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/create")
	public ResponseEntity createProduct(@RequestBody @Valid ProductRequestDTO p) {
		Optional<ProductCategory> currentCategory = categoryRepository.findById(p.category());
		if(currentCategory.isPresent()) {
		Product newProduct = new Product();
		newProduct.setProductName(p.productName());
		newProduct.setCostPrice(p.costPrice());
		newProduct.setSalePrice(p.salePrice());
		newProduct.setCategory(currentCategory.get());
		productRepository.save(newProduct);
		return ResponseEntity.ok(new ProductResponseDTO(newProduct));
		}
		return ResponseEntity.ok("Categoria não encontrada");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity updateProduct(@PathVariable("id") String id, @RequestBody @Valid ProductRequestDTO p) {
		Optional<Product> existingProduct = productRepository.findById(id);
		Optional<ProductCategory> existingCategory = categoryRepository.findById(p.category());
		
		if(existingProduct.isPresent()) {
			existingProduct.get().setProductName(p.productName());
			existingProduct.get().setCategory(existingCategory.get());
			existingProduct.get().setCostPrice(p.costPrice());
			existingProduct.get().setSalePrice(p.salePrice());
			productRepository.save(existingProduct.get());
			return ResponseEntity.ok(existingProduct.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/findall")
	public ResponseEntity findAllProduct() {
		List<ProductResponseDTO> products = productRepository.findAll().stream().map(ProductResponseDTO::new).toList();
		System.out.println(products);
		return ResponseEntity.ok(products);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteProductById(@PathVariable("id") String id) {
		Optional<Product> existingProduct = productRepository.findById(id);
		if(existingProduct.isPresent()) {
			productRepository.deleteById(id);
			System.out.println(existingProduct.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
