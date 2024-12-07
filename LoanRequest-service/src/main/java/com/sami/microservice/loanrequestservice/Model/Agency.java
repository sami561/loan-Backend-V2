package com.sami.microservice.loanrequestservice.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agency {
    private int id;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private int governoratId;
}
