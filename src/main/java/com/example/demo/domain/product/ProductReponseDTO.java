package com.example.demo.domain.product;


public record ProductReponseDTO(String id, String productName, double costPrice, double salePrice) {
	public ProductReponseDTO(Product p) {
		this(p.getId(), p.getProductName(), p.getCostPrice(), p.getSalePrice());
	}
}
