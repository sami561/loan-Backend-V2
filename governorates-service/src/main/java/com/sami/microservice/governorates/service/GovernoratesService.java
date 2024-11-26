package com.sami.microservice.governorates.service;

import com.sami.microservice.governorates.entites.Governorate;
import com.sami.microservice.governorates.repository.GovernorateRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class GovernoratesService implements IGovernoratesService {
    private final GovernorateRepo governorateRepo;
    @Override
    public Governorate createGovernorate(Governorate g) {
        return governorateRepo.save(g);
    }

    @Override
    public Governorate findGovernorateById(int id) {
        return governorateRepo.findById(id).get();
    }

    @Override
    public List<Governorate> findAllGovernorate() {
        return governorateRepo.findAll();
    }

    @Override
    public Governorate updateGovernorate(Governorate g) {
        return governorateRepo.save(g);
    }

    @Override
    public void deleteGovernorate(int id) {
        governorateRepo.deleteById(id);
    }
}
