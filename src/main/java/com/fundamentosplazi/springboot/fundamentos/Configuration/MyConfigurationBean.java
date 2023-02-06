package com.fundamentosplazi.springboot.fundamentos.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentosplazi.springboot.fundamentosBean.MyBean;
import com.fundamentosplazi.springboot.fundamentosBean.MyBean2Implement;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanImplement;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanWithDependency;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanWithDependencyImplement;
import com.fundamentosplazi.springboot.fundamentosBean.MyOperation;
import com.fundamentosplazi.springboot.fundamentosBean.MyOperationImplement;

@Configuration
public class MyConfigurationBean {

	@Bean
	public MyBean beanOperation() {
		
		return new MyBean2Implement();
		}
	

	@Bean
	public MyOperation beanOperationOperation() {
		
		return new MyOperationImplement();
		}
	
	@Bean
	public MyBeanWithDependency beanOperationOperationWithDependency(MyOperation myOperation) {
		
		return new MyBeanWithDependencyImplement(myOperation);
		}
}
