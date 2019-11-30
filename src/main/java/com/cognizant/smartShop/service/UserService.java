package com.cognizant.smartShop.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.smartShop.model.USER;
import com.cognizant.smartShop.repository.UserRepository;

@Service
public class UserService {


	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public boolean modifyUSER(USER user) {
		USER opUSER = userRepository.findByUsername(user.getUsername());
		if (opUSER!=null) {
			userRepository.save(user);
			return true;
		} else
			return false;

	}
	
	@Transactional
	public USER findByUsername(String user) {
		return userRepository.findByUsername(user);
	}

}
