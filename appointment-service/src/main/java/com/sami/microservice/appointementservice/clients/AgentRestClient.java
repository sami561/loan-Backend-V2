package com.sami.microservice.appointementservice.clients;

import com.sami.microservice.appointementservice.Model.Agent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "AGENT-SERVICE")
public interface AgentRestClient {
    @GetMapping("/agent/find/{id}")
    Optional<Agent> getAgentById(@PathVariable int id);
}
