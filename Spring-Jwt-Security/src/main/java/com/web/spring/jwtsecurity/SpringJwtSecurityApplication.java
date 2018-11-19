package com.web.spring.jwtsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringJwtSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtSecurityApplication.class, args);
		System.out.println("server is up...");
	}
}
