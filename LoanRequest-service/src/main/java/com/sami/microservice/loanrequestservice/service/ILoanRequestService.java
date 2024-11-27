package com.sami.microservice.loanrequestservice.service;

import com.sami.microservice.loanrequestservice.entites.LoanRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ILoanRequestService  {
    public LoanRequest createLoanRequest(LoanRequest lr);
    public  LoanRequest findLoanRequestById(int id);
    public List<LoanRequest> findAllLoanRequest();
    public LoanRequest updateLoanRequest(LoanRequest lr);
    public void deleteLoanRequest(int id);
}
