package com.cognizant.smartShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.smartShop.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

}
