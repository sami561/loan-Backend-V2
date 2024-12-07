package com.sami.microservice.agencyservice.clients;

import com.sami.microservice.agencyservice.Model.Governorate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "GOVERNORATES-SERVICE")

public interface GovernorateRestClient {
    @GetMapping("/governorate/find/{id}")
    Governorate getGovernorateById(@PathVariable int id);

}

