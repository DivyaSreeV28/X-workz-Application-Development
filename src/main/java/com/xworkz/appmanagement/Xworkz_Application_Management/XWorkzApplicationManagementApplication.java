package com.xworkz.appmanagement.Xworkz_Application_Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XWorkzApplicationManagementApplication {

	public static void main(String[] args) {
		System.out.println("XWorkzApplicationManagementApplication started");
		System.setProperty("server.servlet.context-path", "/appman");
		SpringApplication.run(XWorkzApplicationManagementApplication.class, args);
		System.out.println("XWorkzApplicationManagementApplication ended");
	}

}
