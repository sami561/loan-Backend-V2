package com.sami.microservice.loanrequestservice.controller;

import com.sami.microservice.loanrequestservice.Model.Agency;
import com.sami.microservice.loanrequestservice.Model.LoanType;
import com.sami.microservice.loanrequestservice.clients.AgencyRestClient;
import com.sami.microservice.loanrequestservice.clients.LoanTypeRestClient;
import com.sami.microservice.loanrequestservice.entites.LoanRequest;
import com.sami.microservice.loanrequestservice.service.ILoanRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/LoanRequest")
@AllArgsConstructor
public class LoanRequestController {
    private final ILoanRequestService iLoanRequestService;
    private final AgencyRestClient agencyRestClient;
    private final LoanTypeRestClient loanTypeRestClient;
    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findLoanRequest(@PathVariable("id") int id) {
        LoanRequest lr = iLoanRequestService.findLoanRequestById(id);

        if (lr == null) {
            return ResponseEntity.notFound().build();  // Return 404 if loan request not found
        }

        // Fetch agency and loan type directly (no Optional)
        Agency agency = agencyRestClient.getAgencyById(lr.getAgencyId());
        LoanType loanType = loanTypeRestClient.getLoanTypeById(lr.getLoantypeId());

        // Check if agency or loan type is missing (null check)
        if (agency == null || loanType == null) {
            return  new ResponseEntity<>("Agency or LoanType not found",HttpStatus.BAD_REQUEST) ; // Return 400 if agency or loan type is missing
        }

        // Set the agency and loan type
        lr.setAgency(agency);
        lr.setLoanType(loanType);

        return ResponseEntity.ok(lr);  // Return 200 OK with the loan request
    }


    @PostMapping("/add")
    public ResponseEntity<Object> addLoanRequest(@RequestBody LoanRequest lr) {
        // Fetch agency and loan type directly (no Optional)
        Agency agency = agencyRestClient.getAgencyById(lr.getAgencyId());
        LoanType loanType = loanTypeRestClient.getLoanTypeById(lr.getLoantypeId());

        // Check if agency or loan type is missing (null check)
        if (agency == null || loanType == null) {
            return new ResponseEntity<>("Agency or Loan Type not found", HttpStatus.BAD_REQUEST);
        }

        // Create loan request if agency and loan type are valid
        LoanRequest lonR = iLoanRequestService.createLoanRequest(lr);

        if (lonR != null) {
            return new ResponseEntity<>(lonR, HttpStatus.CREATED);  // Return 201 Created if loan request created
        } else {
            return new ResponseEntity<>("Failed to create loan request", HttpStatus.CONFLICT);  // Return 409 Conflict if creation fails
        }
    }


    @PutMapping("/update")
    public ResponseEntity<LoanRequest>updateLoanRequest(@RequestBody LoanRequest lr){
        LoanRequest lrr = iLoanRequestService.updateLoanRequest(lr);
        return ResponseEntity.ok(lrr);
    }
    @DeleteMapping("/delete/{id}")
    public void  deleteLoanRequest(@PathVariable("id") int id){
        iLoanRequestService.deleteLoanRequest(id);
    }
    @GetMapping("/all")
    public ResponseEntity<List<LoanRequest>> findAll(){
        return ResponseEntity.ok(iLoanRequestService.findAllLoanRequest());
    }
}
