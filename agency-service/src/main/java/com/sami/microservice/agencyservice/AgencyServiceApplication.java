package com.sami.microservice.agencyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AgencyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgencyServiceApplication.class, args);
    }

}
