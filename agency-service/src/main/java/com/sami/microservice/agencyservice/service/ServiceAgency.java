package com.sami.microservice.agencyservice.service;

import com.sami.microservice.agencyservice.entites.Agency;
import com.sami.microservice.agencyservice.repository.AgencyRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceAgency implements  IServiceAgency {
    private  final AgencyRepo agencyRepo;

    @Override
    public Agency createAgency(Agency a) {
        return agencyRepo.save(a);
    }

    @Override
    public Agency findAgencyById(int id) {
        return agencyRepo.findById(id).get();
    }

    @Override
    public List<Agency> findAllAgency() {
        return agencyRepo.findAll();
    }

    @Override
    public Agency updateAgency(Agency a) {
        return agencyRepo.save(a);
    }

    @Override
    public void deleteAgency(int id) {
    agencyRepo.deleteById(id);
    }
}
