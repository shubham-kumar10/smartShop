package com.cognizant.smartShop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.smartShop.model.USER;
import com.cognizant.smartShop.repository.ProductRepository;
import com.cognizant.smartShop.repository.PurchaseDetailsRepository;
import com.cognizant.smartShop.repository.PurchaseRepository;
import com.cognizant.smartShop.repository.UserRepository;
import com.cognizant.smartShop.service.BillService;
import com.cognizant.smartShop.service.ProductService;
import com.cognizant.smartShop.service.UserService;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
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
	public void testSignUp(){
		
		USER user = new USER("TestUser","Ashley","Cole","pwd",10,"1111111111","U","A","Who?","How?","When?","Him","IDK","Now","Male");
		userRepository.save(user);
		USER tmpUser = userRepository.findByUsername(user.getUsername());
		Assertions.assertEquals(user, tmpUser);
		
	}

}
