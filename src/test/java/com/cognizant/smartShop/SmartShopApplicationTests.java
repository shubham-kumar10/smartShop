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

import com.cognizant.smartShop.model.Bill;
import com.cognizant.smartShop.model.Product;
import com.cognizant.smartShop.model.PurchaseDetails;
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
	@Order(3)
	public void testFindUserByUsername(){
		String testVar = "TestUser";
		Assertions.assertTrue(userService.findByUsername(testVar).getUsername().equals(testVar));
	}
	
	@Test
	@Order(4)
	public void testGetAllProducts(){
		List<Product> products = new ArrayList<Product>();
		products = productService.getAllProducts();
		Assertions.assertEquals(products.isEmpty(), false);
		
	}
	
	@Test
	@Order(5)
	public void testAddProduct(){
		Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Product product = new Product(
				"111","Test User","Test","Testbrand","Test", "1",
				"sto", date, "Stre", "Strf",date,date,
				"String image");
		productService.addProduct(product);
		Product addproduct = productService.getProduct("111");
		Assertions.assertEquals(product, addproduct);
	}
	
	@Test
	@Order(6)
	public void testModifyProduct(){
		Product product = productService.getProduct("111"); 
		String modify = "New Test Brand";
		product.setBrand(modify);
		productService.modifyProduct(product);
		Assertions.assertTrue(productService.getProduct("111").getBrand().equals(modify));
	}
	
	@Test
	@Order(7)
	public void testDelete(){
		Product product = productService.getProduct("111"); 
		List<Product> products = productService.deleteProduct("111");
		Assertions.assertFalse(products.contains(product));
	}
	
//	@Test
//	@Order(8)
//	public void testGenerateBill(){
//		List<Integer> quant = new ArrayList<Integer>();
//		List<Product> products = new ArrayList<Product>();
//		Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//		quant.add(1);
//		products.add(new Product("111","Test User","Test","Testbrand","Test", "1",
//				"sto", date, "Stre", "Strf",date,date,
//				"String image"));
//		Bill bill = new Bill("101010101010",products,quant,50.5);
//		PurchaseDetails pr = purchaseDetailsRepository.findByProduct(products.get(0));
//		Assertions.assertTrue(pr.getProduct().equals((products).get(0)));
//	}
}
