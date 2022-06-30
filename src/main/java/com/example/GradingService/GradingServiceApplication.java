package com.example.GradingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GradingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradingServiceApplication.class, args);
	}

}
