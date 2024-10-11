package com.example.demo.domain.product;

import com.example.demo.domain.productCategory.ProductCategory;

public record ProductResponseDTO(String id, String productName, ProductCategory category, double costPrice, double salePrice) {

	public ProductResponseDTO(Product p) {
		this(p.getId(), p.getProductName(), p.getCategory(), p.getCostPrice(), p.getSalePrice());
	}

}
