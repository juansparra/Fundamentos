package com.fundamentosplazi.springboot.fundamentos.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentosplazi.springboot.fundamentos.caseUse.GetUser;
import com.fundamentosplazi.springboot.fundamentos.caseUse.GetUserImplement;
import com.fundamentosplazi.springboot.fundamentos.service.UserService;

@Configuration
public class CaseUseConfiguration {

	@Bean
		GetUserImplement getUser(UserService userService) {
		
		return new GetUserImplement(userService);
	}
}
