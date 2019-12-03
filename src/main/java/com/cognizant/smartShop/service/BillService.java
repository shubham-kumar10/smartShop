package com.cognizant.smartShop.service;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.smartShop.model.Bill;
import com.cognizant.smartShop.model.Product;
import com.cognizant.smartShop.model.Purchase;
import com.cognizant.smartShop.model.PurchaseDetails;
import com.cognizant.smartShop.model.USER;
import com.cognizant.smartShop.repository.ProductRepository;
import com.cognizant.smartShop.repository.PurchaseDetailsRepository;
import com.cognizant.smartShop.repository.PurchaseRepository;
import com.cognizant.smartShop.repository.UserRepository;

@Service
public class BillService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	PurchaseDetailsRepository purchaseDetailsRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Transactional
	public void generateBill(Bill bill) {
		int rewardPoints = ((int)bill.getTotal()/5);
		USER user = userRepository.findByContact(bill.getContact());
		System.out.println(user);
		Purchase pr = new Purchase(userRepository.findByContact(bill.getContact()),(int)bill.getTotal(),rewardPoints,
				new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		
		purchaseRepository.save(pr);
		int i=0;
		PurchaseDetails pd = null;
		
		for(Product product : bill.getProductList()){
			int Qty = bill.getQuantity().get(i);
			int Stock = Integer.parseInt(product.getStock_count());
			pd = new PurchaseDetails(product,pr,Qty);
			product.setStock_count(Integer.toString(Stock - Qty));
			i++;
			productRepository.save(product);
			purchaseDetailsRepository.save(pd);
		}
		
		
		
	}

}
