package com.fundamentosplazi.springboot.fundamentos.caseUse;

import org.springframework.stereotype.Component;

import com.fundamentosplazi.springboot.fundamentos.service.UserService;

@Component
public class DeleteUser {
	private UserService userService;

	public DeleteUser(UserService userService) {
		this.userService = userService;
	}

	public void remove(Long id) {
		// TODO Auto-generated method stub
		userService.delete(id);
	}
}
