package com.example.javademo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.javademo.serviceImplementation.BankAccountServiceImpl;
import com.example.javademo.serviceImplementation.UserServiceImpl;


@Configuration
public class ServiceConfig {
	
	  @Bean
	  UserServiceImpl myService() {
	        return new UserServiceImpl();
	    }
	  
	  @Bean
	  BankAccountServiceImpl myService2() {
	        return new BankAccountServiceImpl();
	    }
	  

}
