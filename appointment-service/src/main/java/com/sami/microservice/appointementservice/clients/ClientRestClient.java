package com.sami.microservice.appointementservice.clients;

import com.sami.microservice.appointementservice.Model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestClient {
    @GetMapping("/client/find/{id}")
    Optional<Client> getClientById(@PathVariable int id);
}
