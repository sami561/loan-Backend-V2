package com.sami.microservice.loanrequestservice.entites;

import com.sami.microservice.loanrequestservice.Model.Agency;
import com.sami.microservice.loanrequestservice.Model.LoanType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private BigDecimal amountRequested;
    private LocalDate requestedDate;
    private String status;
    private String borrowerName;
    private BigDecimal borrowerIncome;
    private String borrowerAddress;
    private int loantypeId;
    @Transient
    private LoanType loanType;
    private  int agencyId;
    @Transient
    private Agency agency;

}
