package com.example.demo.domain.product;


import com.example.demo.domain.productCategory.ProductCategory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
	
	@NotNull
	private String productName;
	
	private String description;
	
	@NotNull
	private double costPrice;
	
	@NotNull
	private double salePrice;
	
	private double stock;
	
	private String urlImage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private ProductCategory category;
	
	
	public Product(@NotNull String productName, String description, @NotNull double costPrice,
			@NotNull double salePrice, double stock, String urlImage, ProductCategory category) {
		this.productName = productName;
		this.description = description;
		this.costPrice = costPrice;
		this.salePrice = salePrice;
		this.stock = stock;
		this.urlImage = urlImage;
		this.category = category;
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
	

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}
	public double getStock() {
		return stock;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", costPrice="
				+ costPrice + ", salePrice=" + salePrice + ", stock=" + stock + ", urlImage=" + urlImage + ", category="
				+ category + "]";
	}
	
	

}
