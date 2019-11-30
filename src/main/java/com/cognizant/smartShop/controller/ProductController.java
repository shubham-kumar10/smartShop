package com.cognizant.smartShop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartShop.model.Product;
import com.cognizant.smartShop.service.ProductService;

@RestController
@RequestMapping("/list")
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts(){
		LOGGER.info("Get all products has been requested.");
		return productService.getAllProducts();
	}
	
	@PostMapping("/add")
	public void addProduct(@RequestBody Product product){
		LOGGER.info("A new product is being added.");
		productService.addProduct(product);
	}

	@GetMapping("/{code}")
	public Product getProduct(@PathVariable("code") String code){
		return productService.getProduct(code);
	}
	
	@DeleteMapping("/{code}")
	public List<Product> deleteProduct(@PathVariable String code){
		return productService.deleteProduct(code);
	}
	
	@PutMapping
	public void modifyProduct(@RequestBody Product product){
		productService.modifyProduct(product);
	}
}
