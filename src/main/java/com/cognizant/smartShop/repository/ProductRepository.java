package com.cognizant.smartShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.smartShop.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	
	List<Product> findAll();
	Product findAllByCode(String code);
}
