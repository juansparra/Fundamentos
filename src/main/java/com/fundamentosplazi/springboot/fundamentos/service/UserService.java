package com.fundamentosplazi.springboot.fundamentos.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.fundamentosplazi.springboot.fundamentos.entity.User;
import com.fundamentosplazi.springboot.fundamentos.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	private final org.apache.juli.logging.Log LOG = LogFactory.getLog(UserService.class);
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Transactional
	public void saveTransactional(List<User> users) {
		
		users.stream()
		.peek(user -> LOG.info("Usuario insertado " + user))
		.forEach(userRepository::save);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
}
