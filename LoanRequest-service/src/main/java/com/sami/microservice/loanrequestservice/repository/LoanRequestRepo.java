package com.sami.microservice.loanrequestservice.repository;

import com.sami.microservice.loanrequestservice.entites.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRequestRepo extends JpaRepository<LoanRequest,Integer> {
}
