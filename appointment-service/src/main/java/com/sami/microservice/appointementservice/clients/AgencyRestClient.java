package com.sami.microservice.appointementservice.clients;

import com.sami.microservice.appointementservice.Model.Agency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "AGENCY-SERVICE")
public interface AgencyRestClient {
    @GetMapping("/agency/find/{id}")
    Optional<Agency> getAgencyById(@PathVariable int id);
}
