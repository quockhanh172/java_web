package com.java.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan({"com.java.controller","com.java.security"})
public class JavawebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavawebApplication.class, args);
	}

}
