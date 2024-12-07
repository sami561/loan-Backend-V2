package com.sami.microservice.agencyservice.entites;

import com.sami.microservice.agencyservice.Model.Governorate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private int governoratId;
    @Transient
    private Governorate governorate;
}
