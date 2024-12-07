package com.sami.microservice.loanrequestservice.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanType {
    int id;
    private String name;
    private float interestRate;
    private float minAmount;
    private float maxAmount;
    private Integer duration;
    private String description;
}
