package com.sami.microservice.agencyservice.repository;

import com.sami.microservice.agencyservice.entites.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepo extends JpaRepository<Agency,Integer> {
}
