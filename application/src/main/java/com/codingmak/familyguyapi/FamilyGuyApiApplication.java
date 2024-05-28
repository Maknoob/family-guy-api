package com.codingmak.familyguyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.codingmak")
public class FamilyGuyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyGuyApiApplication.class, args);
	}

}
