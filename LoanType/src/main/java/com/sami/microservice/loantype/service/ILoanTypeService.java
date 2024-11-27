package com.sami.microservice.loantype.service;

import com.sami.microservice.loantype.entites.LoanType;

import java.util.List;

public interface ILoanTypeService {
    public LoanType createLoanType(LoanType lt);
    public  LoanType findLoanTypeById(int id);
    public List<LoanType> findAllLoanType();
    public LoanType updateLoanType(LoanType lr);
    public void deleteLoanType(int id);
}
