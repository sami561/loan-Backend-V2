package com.sami.microservice.loanrequestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LoanRequestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanRequestServiceApplication.class, args);
	}

}
