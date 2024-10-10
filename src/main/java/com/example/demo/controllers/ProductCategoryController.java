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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.product.ProductDTO;
import com.example.demo.domain.productCategory.CategoryDTO;
import com.example.demo.domain.productCategory.ProductCategory;
import com.example.demo.repositories.ProductCategoryRepository;

@RestController
@RequestMapping("/category")
public class ProductCategoryController {
	
	@Autowired
	ProductCategoryRepository categoryRepository;
	
	
	@GetMapping("/findall")
	public ResponseEntity<List<ProductCategory>> getCategories(){
		List<ProductCategory> categories = categoryRepository.findAll();
		return ResponseEntity.ok(categories);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createCategory(@RequestBody CategoryDTO category) {
		if(categoryRepository.findByName(category.name()) == null) {
			ProductCategory productCategory = new ProductCategory(category.name());
			categoryRepository.save(productCategory);
			return ResponseEntity.ok("Categoria cadastrada com sucesso!");
		}
		
		return ResponseEntity.ok("Categoria já existe");
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateCategory(@PathVariable String id, @RequestBody CategoryDTO category) {
		Optional<ProductCategory> productCategory = categoryRepository.findById(id);
		System.out.println(productCategory.get());
		if(productCategory.isPresent()) {
			productCategory.get().setName(category.name());
			categoryRepository.save(productCategory.get());
			return ResponseEntity.ok("Categoria atualizada com sucesso!");
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> createCategory(@PathVariable String id, String category) {
		categoryRepository.deleteById(id);
		
		return ResponseEntity.ok("Categoria deletada com sucesso.");
	}
}
