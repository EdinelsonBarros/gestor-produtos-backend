package com.example.demo.domain.product;

import com.example.demo.domain.productCategory.ProductCategory;

public record ProductDTO(String id, String productName, double costPrice, double salePrice) {
	public ProductDTO(Product p) {
		this(p.getId(), p.getProductName(), p.getCostPrice(), p.getSalePrice());
	}
}
