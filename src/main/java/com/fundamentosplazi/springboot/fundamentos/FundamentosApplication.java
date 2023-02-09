package com.fundamentosplazi.springboot.fundamentos;



import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.fundamentosplazi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplazi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplazi.springboot.fundamentosBean.MyBean;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanWithDependency;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanWithProperties;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{
	
	private ComponentDependency componentDependecy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	
public FundamentosApplication(ComponentDependency componentDependecy, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo) {
	this.componentDependecy = componentDependecy;
	this.myBean = myBean;
	this.myBeanWithDependency = myBeanWithDependency;
	this.myBeanWithProperties = myBeanWithProperties;
	this.userPojo = userPojo;
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
		
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword() + "a"+userPojo.getAge());
	}

}
