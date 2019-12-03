package com.cognizant.smartShop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.smartShop.model.Bill;
import com.cognizant.smartShop.model.Product;
import com.cognizant.smartShop.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Transactional
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Transactional
	public void addProduct(Product product){
		productRepository.save(product);
	}
	
	@Transactional
	public Product getProduct(String id){
		return productRepository.findAllByCode(id);
	}

	@Transactional
	public List<Product> deleteProduct(String code) {
		productRepository.deleteById(code);
		return productRepository.findAll();
	}

	@Transactional
	public boolean modifyProduct(Product product) {
		System.out.println(product);
		System.out.println(product.getName());
		Product opProduct = productRepository.findAllByCode(product.getCode());
		System.out.println(opProduct);
		if (opProduct!=null) {
			productRepository.save(product);
			return true;
		} else
			return false;
		
	}

}
