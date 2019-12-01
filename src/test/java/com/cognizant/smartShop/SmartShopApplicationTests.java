package com.cognizant.smartShop;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cognizant.smartShop.model.Product;
import com.cognizant.smartShop.model.USER;
import com.cognizant.smartShop.repository.ProductRepository;
import com.cognizant.smartShop.repository.PurchaseDetailsRepository;
import com.cognizant.smartShop.repository.PurchaseRepository;
import com.cognizant.smartShop.repository.UserRepository;
import com.cognizant.smartShop.service.BillService;
import com.cognizant.smartShop.service.ProductService;
import com.cognizant.smartShop.service.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SmartShopApplicationTests {

	void contextLoads() {
	}
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	BillService billService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	PurchaseDetailsRepository purchaseDetailsRepository;
		
	@Test
	@Order(1)
	public void testSignUp(){
		USER user = new USER("TestUser","Ashley","Cole","pwd",10,"1111111111","U","A","Who?","How?","When?","Him","IDK","Now","Male");
		userRepository.save(user);
		USER tmpUser = userRepository.findByUsername(user.getUsername());
		Assertions.assertEquals(user.equals(tmpUser), true);
	}
	
	@Test
	@Order(2)
	public void testModify(){
		USER user = userRepository.findByUsername("TestUser");
		user.setAge(100);
		userRepository.save(user);
		Assertions.assertTrue(userRepository.findByUsername("TestUser").getAge()==100);
		
	}
	
	@Test
	public void testGetAllProducts(){
		List<Product> products = new ArrayList<Product>();
		products = productService.getAllProducts();
		Assertions.assertEquals(products.isEmpty(), false);
		
	}
	
	@Test
	public void testAddProduct(){
		
	}
	
	@Test
	public void testGetProduct(){
		Product product = productService.getProduct("111");
		Assertions.assertFalse(product.getName().equals("TestProduct"));
	}
	
	@Test
	@Order(3)
	public void testFindUserByUsername(){
		String testVar = "TestUser";
		Assertions.assertTrue(userService.findByUsername(testVar).getUsername().equals(testVar));
	}
	

}
