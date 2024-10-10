package com.example.demo.domain.productCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String category_id; 
	
	@NotNull
	private String name;
	
	

	public ProductCategory() {
		
	}

	public ProductCategory(@NotNull String name) {
		
		this.name = name;
	}

	public String getCategory_id() {
		return category_id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + category_id + ", name=" + name + "]";
	}
	
	
	
}
