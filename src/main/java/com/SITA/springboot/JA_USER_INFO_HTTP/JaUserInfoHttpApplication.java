package com.SITA.springboot.JA_USER_INFO_HTTP;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.SITA.springboot.JA_USER_INFO_HTTP" })
public class JaUserInfoHttpApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaUserInfoHttpApplication.class, args);
	}
	
}
