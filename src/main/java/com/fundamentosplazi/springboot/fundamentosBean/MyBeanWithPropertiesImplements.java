package com.fundamentosplazi.springboot.fundamentosBean;

public class MyBeanWithPropertiesImplements implements MyBeanWithProperties{

	
	private String nombre;
	private String apellido;
	private String age;
	
	
	public MyBeanWithPropertiesImplements (String nombre, String apellido, String age) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.age = age;
	}
	
	@Override
	public String function() {
		// TODO Auto-generated method stub
		
		return nombre + "-" + apellido;
	}

}
