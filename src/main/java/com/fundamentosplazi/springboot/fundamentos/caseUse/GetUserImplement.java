package com.fundamentosplazi.springboot.fundamentos.caseUse;

import java.util.List;

import com.fundamentosplazi.springboot.fundamentos.entity.User;
import com.fundamentosplazi.springboot.fundamentos.service.UserService;

public class GetUserImplement implements GetUser{

	private UserService userService;
	
	public GetUserImplement(UserService userService) {
		this.userService = userService;
	}
	
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userService.getAllUsers();
	}

}
