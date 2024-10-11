package com.example.demo.domain.product;

public record ProductRequestDTO(String productName, String description, String category, double costPrice, double salePrice, double stock, String urlImage) {

}
