package com.sami.microservice.loanrequestservice.service;

import com.sami.microservice.loanrequestservice.entites.LoanRequest;
import com.sami.microservice.loanrequestservice.repository.LoanRequestRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class LoanRequestService implements  ILoanRequestService{
    private final LoanRequestRepo loanRequestRepo;
    @Override
    public LoanRequest createLoanRequest(LoanRequest lr) {
        return loanRequestRepo.save(lr);
    }

    @Override
    public LoanRequest findLoanRequestById(int id) {
        return loanRequestRepo.findById(id).get();
    }

    @Override
    public List<LoanRequest> findAllLoanRequest() {
        return loanRequestRepo.findAll();
    }

    @Override
    public LoanRequest updateLoanRequest(LoanRequest lr) {
        return loanRequestRepo.save(lr);
    }

    @Override
    public void deleteLoanRequest(int id) {
    loanRequestRepo.deleteById(id);
    }
}
