package com.xworkz.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootWebApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/springboot");
		SpringApplication.run(SpringbootWebApplication.class, args);
		System.out.println("SpringbootWebApplication ended");
	}

}
