package com.fundamentosplazi.springboot.fundamentos.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fundamentosplazi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanWithProperties;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanWithPropertiesImplements;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
@Value("${value.name}")
private String name;

@Value("${value.apellido}")
private String apellido;

@Value("${value.random}")
private String random;

@Value("${jdbc.url}")
private String jdbcUrl;

@Value("${driver}")
private String driver;

@Value("${username}")
private String username;

@Value("${password}")
private String password;
@Bean
public MyBeanWithProperties function() {
	return new MyBeanWithPropertiesImplements(name,apellido, random);
}

@Bean
public DataSource dataSource() {
	
	DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
	dataSourceBuilder.driverClassName(driver);
	dataSourceBuilder.url(jdbcUrl);
	dataSourceBuilder.username(username);
	dataSourceBuilder.password(password);
	
	return dataSourceBuilder.build();
	
}
}

