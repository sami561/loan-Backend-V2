package com.sami.microservice.agencyservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Governorate {
    private int id;
    private String name;
    private String region;
    private String capital;
    private Long population;
    private Double areaSize;
    private String postalCode;
}
