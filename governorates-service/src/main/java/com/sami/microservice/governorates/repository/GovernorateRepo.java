package com.sami.microservice.governorates.repository;

import com.sami.microservice.governorates.entites.Governorate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GovernorateRepo extends JpaRepository<Governorate,Integer> {
}
