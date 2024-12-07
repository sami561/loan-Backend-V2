package com.sami.microservice.loantype.controller;


import com.sami.microservice.loantype.entites.LoanType;
import com.sami.microservice.loantype.service.ILoanTypeService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/LoanType")
@AllArgsConstructor
public class LoanTypeController {
    private final ILoanTypeService iLoanTypeService;
    @GetMapping("/find/{id}")
    public ResponseEntity<LoanType> findLoanType(@PathVariable("id") int id){
        LoanType lt = iLoanTypeService.findLoanTypeById(id);
        if (lt==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(lt);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<LoanType>addLoanType(@RequestBody LoanType lr){
        LoanType gov = iLoanTypeService.createLoanType(lr);
        return ResponseEntity.ok(gov);
    }
    @PutMapping("/update")
    public ResponseEntity<LoanType>updateLoanType(@RequestBody LoanType lr){
        LoanType lrr = iLoanTypeService.updateLoanType(lr);
        return ResponseEntity.ok(lrr);
    }
    @DeleteMapping("/delete/{id}")
    public void  deleteLoanType(@PathVariable("id") int id){
        iLoanTypeService.deleteLoanType(id);
    }
    @GetMapping("/all")
    public ResponseEntity<List<LoanType>> findAll(){
        return ResponseEntity.ok(iLoanTypeService.findAllLoanType());
    }

}
