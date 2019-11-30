package com.cognizant.smartShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.smartShop.model.USER;

public interface UserRepository extends JpaRepository<USER, Integer> {

	USER findByUsername(String username);

	USER findByContact(String contact);

	List<USER> findAllByStatus(String status);

}
