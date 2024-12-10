package com.sami.microservice.agent.service;

import com.sami.microservice.agent.entities.Agent;
import com.sami.microservice.agent.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAgent implements  IServiceAgent{
    @Autowired
      AgentRepository agentRepository;
    @Override
    public Agent createAgent(Agent a) {
        return agentRepository.save(a);
    }

    @Override
    public Agent findAgentById(int id) {
        return agentRepository.findById(id).get();
    }

    @Override
    public List<Agent> findAllAgent() {
        return agentRepository.findAll();
    }

    @Override
    public Agent updateAgent(Agent a) {
        return agentRepository.save(a);
    }

    @Override
    public void deleteAgent(int id) {
        agentRepository.deleteById(id);
    }
}
