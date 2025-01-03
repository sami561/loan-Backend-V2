package com.sami.microservice.appointementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppointementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointementServiceApplication.class, args);
	}

}
