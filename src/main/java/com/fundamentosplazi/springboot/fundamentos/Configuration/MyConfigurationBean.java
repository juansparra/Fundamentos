package com.fundamentosplazi.springboot.fundamentos.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentosplazi.springboot.fundamentosBean.MyBean;
import com.fundamentosplazi.springboot.fundamentosBean.MyBean2Implement;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanImplement;

@Configuration
public class MyConfigurationBean {

	@Bean
	public MyBean beanOperation() {
		
		return new MyBean2Implement();
		}
}
