package com.fundamentosplazi.springboot.fundamentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fundamentosplazi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplazi.springboot.fundamentosBean.MyBean;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanWithDependency;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{
	
	private ComponentDependency componentDependecy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
public FundamentosApplication(ComponentDependency componentDependecy, MyBean myBean, MyBeanWithDependency myBeanWithDependency) {
	this.componentDependecy = componentDependecy;
	this.myBean = myBean;
	this.myBeanWithDependency = myBeanWithDependency;
}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}
	
	@Override
	public void run(String... args) {
		// TODO Auto-generated method stub
		
		
		componentDependecy.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
	}

}
