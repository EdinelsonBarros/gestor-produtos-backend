package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.productCategory.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {
	ProductCategory findByName(String name);
}
