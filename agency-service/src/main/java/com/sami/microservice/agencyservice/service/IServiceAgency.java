package com.sami.microservice.agencyservice.service;

import com.sami.microservice.agencyservice.entites.Agency;

import java.util.List;

public interface IServiceAgency {
    public Agency createAgency(Agency a);
    public  Agency findAgencyById(int id);
    public List<Agency> findAllAgency();
    public Agency updateAgency(Agency a);
    public void deleteAgency(int id);
}
