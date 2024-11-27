package com.sami.microservice.loanrequestservice.controller;

import com.sami.microservice.loanrequestservice.entites.LoanRequest;
import com.sami.microservice.loanrequestservice.service.ILoanRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/LoanRequest")
@AllArgsConstructor
public class LoanRequestController {
    private final ILoanRequestService iLoanRequestService;
    @GetMapping("/find/{id}")
    public ResponseEntity<LoanRequest> findLoanRequest(@PathVariable("id") int id){
        LoanRequest lr = iLoanRequestService.findLoanRequestById(id);
        if (lr==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(lr);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<LoanRequest>addLoanRequest(@RequestBody LoanRequest lr){
        LoanRequest gov = iLoanRequestService.createLoanRequest(lr);
        return ResponseEntity.ok(gov);
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
