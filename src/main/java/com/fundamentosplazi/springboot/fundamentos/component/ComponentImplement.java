package com.fundamentosplazi.springboot.fundamentos.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ComponentImplement implements ComponentDependency{

	@Override
	public void saludar() {
		// TODO Auto-generated method stub
		System.out.println("holamundo asdasdasdasdasda");
	}

}

