package com.sami.microservice.loantype.repository;

import com.sami.microservice.loantype.entites.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTypeRepo extends JpaRepository<LoanType,Integer> {
}
