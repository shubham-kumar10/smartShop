package com.cognizant.smartShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.smartShop.model.Product;
import com.cognizant.smartShop.model.PurchaseDetails;

public interface PurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Integer>{
	PurchaseDetails findByProduct(Product product);

}
