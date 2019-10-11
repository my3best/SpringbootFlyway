package com.flywaycrudsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages={"com.flywaycrudsample"})
public class SpringBootFlywayApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFlywayApplication.class, args);
	}
}
