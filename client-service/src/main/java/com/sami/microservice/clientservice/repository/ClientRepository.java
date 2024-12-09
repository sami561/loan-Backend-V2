package com.sami.microservice.clientservice.repository;

import com.sami.microservice.clientservice.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
