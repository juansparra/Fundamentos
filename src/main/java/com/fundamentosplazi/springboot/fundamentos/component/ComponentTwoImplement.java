package com.fundamentosplazi.springboot.fundamentos.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class ComponentTwoImplement implements ComponentDependency{

	@Override
	public void saludar() {
		// TODO Auto-generated method stub
		System.out.println("Hola mundo desde mi componente 2");
	}

}
