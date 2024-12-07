package com.sami.microservice.agencyservice.controller;

import com.sami.microservice.agencyservice.Model.Governorate;
import com.sami.microservice.agencyservice.clients.GovernorateRestClient;
import com.sami.microservice.agencyservice.entites.Agency;
import com.sami.microservice.agencyservice.repository.AgencyRepo;
import com.sami.microservice.agencyservice.service.IServiceAgency;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/agency")
@AllArgsConstructor
public class AgencyController {
    private final IServiceAgency iServiceAgency;
    private final  GovernorateRestClient governorateRestClient;
    @GetMapping("/find/{id}")
    public ResponseEntity<Agency> findAgency(@PathVariable("id") int id){

        Agency d = iServiceAgency.findAgencyById(id);
        Governorate governorate= governorateRestClient.getGovernorateById(d.getGovernoratId());
        d.setGovernorate(governorate);
        if (d==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(d);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Object> addAgency(@RequestBody Agency a) {
        Governorate governorate = governorateRestClient.getGovernorateById(a.getGovernoratId());

        if (governorate != null) {
            Agency ag1 = iServiceAgency.createAgency(a);

            if (ag1 != null) {
                return new ResponseEntity<>(ag1, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Agency can't be created", HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("Governorate not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Agency>updateAgency(@RequestBody Agency a){
        Agency dr = iServiceAgency.updateAgency(a);
        return ResponseEntity.ok(dr);
    }
    @DeleteMapping("/delete/{id}")
    public void  deleteAgency(@PathVariable("id") int id){
       iServiceAgency.deleteAgency(id);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Agency>> findAll(){
        return ResponseEntity.ok(iServiceAgency.findAllAgency());
    }
}
