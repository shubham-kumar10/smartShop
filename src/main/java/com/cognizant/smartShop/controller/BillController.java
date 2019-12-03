package com.cognizant.smartShop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartShop.model.Bill;
import com.cognizant.smartShop.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);

	@Autowired
	BillService billService;
	
	@PostMapping("/add")
	public boolean generateBill(@RequestBody Bill bill){
		LOGGER.info("A new bill is being added.");
		System.out.println(bill);
		billService.generateBill(bill);
		return true;
	}

}
