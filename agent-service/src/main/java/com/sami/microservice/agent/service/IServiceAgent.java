package com.sami.microservice.agent.service;


import com.sami.microservice.agent.entities.Agent;

import java.util.List;

public interface IServiceAgent {
    public Agent createAgent(Agent p);
    public  Agent findAgentById(int id);
    public List<Agent> findAllAgent();
    public Agent updateAgent(Agent a);
    public void deleteAgent(int id);
}
