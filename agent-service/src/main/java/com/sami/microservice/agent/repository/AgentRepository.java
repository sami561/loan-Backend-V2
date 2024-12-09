package com.sami.microservice.agent.repository;


import com.sami.microservice.agent.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent,Integer> {
}
