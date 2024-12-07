package com.sami.microservice.loanrequestservice.clients;

import com.sami.microservice.loanrequestservice.Model.LoanType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "LOANTYPE-SERVICE")
public interface LoanTypeRestClient {
    @GetMapping("/LoanType/find/{id}")
    LoanType getLoanTypeById(@PathVariable int id);

}


