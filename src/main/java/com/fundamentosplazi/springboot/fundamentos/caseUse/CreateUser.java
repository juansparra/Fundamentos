package com.fundamentosplazi.springboot.fundamentos.caseUse;

import org.springframework.stereotype.Component;

import com.fundamentosplazi.springboot.fundamentos.entity.User;
import com.fundamentosplazi.springboot.fundamentos.service.UserService;


@Component
public class CreateUser {
private UserService userService;

public CreateUser(UserService userService) {
	this.userService = userService;
}

public User save(User newUser) {
	// TODO Auto-generated method stub
	return userService.save(newUser);
	
}
}
