package com.tcs.springbootdemo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// 1. @SpringBootConfiguration ====@Configuration

//2. @EnableAutoConfiguration
//here it enables spring boot to auto-configure the application context.
// it automaticaly creates and register beans based on both the included jar files in the classpath & beans defined by us.
// Spring MVC ===> spring web jar and tomcat server plugin.
// wehn spring web starter=== > it will include the tomcat server mvc based conf.g
// exculde names autoconfig we want to skipp specify that list to @enableautoconfiguration

//3. @ComponentScan

public class SpringbootdemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringbootdemoApplication.class, args);
		
		String [] beanNames= applicationContext.getBeanDefinitionNames();
		
		Arrays.sort(beanNames);
		
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

}
