package com.example.demo.domain.product;


public record ProductDTO(String id, String productName, double costPrice, double salePrice) {
	public ProductDTO(Product p) {
		this(p.getId(), p.getProductName(), p.getCostPrice(), p.getSalePrice());
	}
}
