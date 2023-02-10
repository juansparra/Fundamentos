package com.fundamentosplazi.springboot.fundamentos.caseUse;

import org.springframework.stereotype.Component;

import com.fundamentosplazi.springboot.fundamentos.entity.User;
import com.fundamentosplazi.springboot.fundamentos.service.UserService;

@Component
public class UpdateUser {
	private UserService userService;

	public UpdateUser(UserService userService) {
		this.userService = userService;
	}

	public User update(User newUser, Long id) {
		// TODO Auto-generated method stub
		return userService.update(newUser,id);
	}
}
