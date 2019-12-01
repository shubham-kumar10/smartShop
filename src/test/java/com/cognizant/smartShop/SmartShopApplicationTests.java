package com.cognizant.smartShop;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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
		Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Product product = new Product(
				"111","Test User","Test","Testbrand","Testquantity", "Tetsrate_per_quantity",
				"stock_count", date, "String aisle", "String shelf",date,date,
				"String image");
		productService.addProduct(product);
		productService.getProduct("111");
		Product addproduct = productService.getProduct("111");
		Assertions.assertTrue(product.equals(addproduct));
	}
	
	
	@Test
	public void testDelete(){
		Product product = productService.getProduct("111"); 
		List<Product> products = productService.deleteProduct("111");
		Assertions.assertFalse(products.contains(product));
	}
	
	
	@Test
	@Order(3)
	public void testFindUserByUsername(){
		String testVar = "TestUser";
		Assertions.assertTrue(userService.findByUsername(testVar).getUsername().equals(testVar));
	}
	

}
