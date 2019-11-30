package com.cognizant.smartShop.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartShop.model.USER;
import com.cognizant.smartShop.service.AppUserDetailsService;
import com.cognizant.smartShop.exceptions.UserAlreadyExistsException;;

@RestController
@RequestMapping("/register")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@PostMapping
	public void signupUser(@RequestBody @Valid USER newUser) throws UserAlreadyExistsException {
		LOGGER.info("Start of signupUser");
		LOGGER.debug("new User is {}",newUser);
		appUserDetailsService.signup(newUser);
		LOGGER.info("End of signupUser");
	}
	
	@GetMapping
	public String Test(){
		return "Working";
	}
	
	@PostMapping("/admin")
	public void signupAdmin(@RequestBody @Valid USER newUser) throws UserAlreadyExistsException {
		appUserDetailsService.signup(newUser);
	}

}
