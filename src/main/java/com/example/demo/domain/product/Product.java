package com.example.demo.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "products")
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
	
	public Product(String id, String productName, double costPrice, double salePrice) {
		this.id = id;
		this.productName = productName;
		this.costPrice = costPrice;
		this.salePrice = salePrice;
	}
	public Product(String id) {
		this.id = id;
	}
	
	public Product() {}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

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

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", costPrice=" + costPrice + ", salePrice="
				+ salePrice + "]";
	}
	
	

}
