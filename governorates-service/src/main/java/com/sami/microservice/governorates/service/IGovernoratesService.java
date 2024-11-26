package com.sami.microservice.governorates.service;

import com.sami.microservice.governorates.entites.Governorate;

import java.util.List;

public interface IGovernoratesService {

    public Governorate createGovernorate(Governorate g);
    public  Governorate findGovernorateById(int id);
    public List<Governorate> findAllGovernorate();
    public Governorate updateGovernorate(Governorate g);
    public void deleteGovernorate(int id);
}
