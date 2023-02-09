package com.fundamentosplazi.springboot.fundamentos.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentosplazi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanWithProperties;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanWithPropertiesImplements;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
@Value("${value.name}")
private String name;

@Value("${value.apellido}")
private String apellido;

@Value("${value.random}")
private String random;

@Bean
public MyBeanWithProperties function() {
	return new MyBeanWithPropertiesImplements(name,apellido, random);
}

@Bean
public DataSource dataSource() {
	
	DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
	dataSourceBuilder.driverClassName("org.h2.Driver");
	dataSourceBuilder.url("jdbc:h2:mem:testdb");
	dataSourceBuilder.username("SA");
	dataSourceBuilder.password("");
	
	return dataSourceBuilder.build();
	
}
}

