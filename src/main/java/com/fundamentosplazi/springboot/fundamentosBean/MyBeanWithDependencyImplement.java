package com.fundamentosplazi.springboot.fundamentosBean;

import org.apache.commons.logging.Log;
import org.apache.juli.logging.LogFactory;

import com.fundamentosplazi.springboot.fundamentos.FundamentosApplication;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

	
	MyOperation myOperation;
	
	private final org.apache.juli.logging.Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
	public MyBeanWithDependencyImplement(MyOperation myOperation) {
		super();
		this.myOperation = myOperation;
	}


	@Override
	public void printWithDependency() {
		// TODO Auto-generated method stub
		LOGGER.info("hemos entrado al metodo printWithDependency");
		int numero = 1;
		LOGGER.debug("El numero como parametro es :" + numero);
		System.out.println(myOperation.sum(numero));

		System.out.println("Holamundo desde la implementacion de un bean con dependecy");
	}

}
