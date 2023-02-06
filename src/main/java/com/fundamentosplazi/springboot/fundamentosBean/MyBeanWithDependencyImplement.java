package com.fundamentosplazi.springboot.fundamentosBean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

	
	MyOperation myOperation;
	
	
	public MyBeanWithDependencyImplement(MyOperation myOperation) {
		super();
		this.myOperation = myOperation;
	}


	@Override
	public void printWithDependency() {
		// TODO Auto-generated method stub
		int numero = 1;
		
		System.out.println(myOperation.sum(numero));

		System.out.println("Holamundo desde la implementacion de un bean con dependecy");
	}

}
