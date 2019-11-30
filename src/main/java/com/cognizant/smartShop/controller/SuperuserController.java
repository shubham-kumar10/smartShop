package com.cognizant.smartShop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.smartShop.model.USER;
import com.cognizant.smartShop.service.AppUserDetailsService;
import com.cognizant.smartShop.service.UserService;;

@RestController
@RequestMapping("/admin")
public class SuperuserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Autowired
	UserService userService;

	@GetMapping("/requests")
	public List<USER> userList(){
		return appUserDetailsService.userList();
	}
	
	@GetMapping("/{user}")
	public USER getMovie(@PathVariable("user") String user) {
		return userService.findByUsername(user);
	}
	
	@PutMapping
	public List<USER> modifyStatus(@RequestBody USER user) {
		userService.modifyUSER(user);
		return appUserDetailsService.userList();
	}
	

}
