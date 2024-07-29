package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	
	@Modifying
    @Transactional
	@Query(value = "DELETE FROM products WHERE id = ?1")
	public void excluirPorId(String id);
}
