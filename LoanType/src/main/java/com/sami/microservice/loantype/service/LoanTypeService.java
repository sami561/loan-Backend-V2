package com.sami.microservice.loantype.service;

import com.sami.microservice.loantype.entites.LoanType;
import com.sami.microservice.loantype.repository.LoanTypeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoanTypeService implements  ILoanTypeService {
    private final LoanTypeRepo loanTypeRepo;

    @Override
    public LoanType createLoanType(LoanType lt) {
        return loanTypeRepo.save(lt);
    }

    @Override
    public LoanType findLoanTypeById(int id) {
        return loanTypeRepo.findById(id).get();
    }

    @Override
    public List<LoanType> findAllLoanType() {
        return loanTypeRepo.findAll();
    }

    @Override
    public LoanType updateLoanType(LoanType lr) {
        return loanTypeRepo.save(lr);
    }

    @Override
    public void deleteLoanType(int id) {
    loanTypeRepo.deleteById(id);
    }
}
