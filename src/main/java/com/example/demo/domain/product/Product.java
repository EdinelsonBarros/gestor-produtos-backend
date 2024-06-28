package com.example.demo.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "products")
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	
	private String productName;
	
	
	private double costPrice;
	
	
	private double salePrice;
	
	public Product(String productName, double costPrice, double salePrice) {
		this.productName = productName;
		this.costPrice = costPrice;
		this.salePrice = salePrice;
	}
	
	public Product() {}

	public String getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public double getSalePrice() {
		return salePrice;
	}
	
	

}
