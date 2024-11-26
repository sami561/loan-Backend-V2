package com.sami.microservice.agencyservice.controller;

import com.sami.microservice.agencyservice.entites.Agency;
import com.sami.microservice.agencyservice.service.IServiceAgency;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/agency")
@AllArgsConstructor
public class AgencyController {
    private final IServiceAgency iServiceAgency;
    @GetMapping("/find/{id}")
    public ResponseEntity<Agency> findAgency(@PathVariable("id") int id){
        Agency d = iServiceAgency.findAgencyById(id);
        if (d==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(d);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Agency>addAgency(@RequestBody Agency a){
        Agency ag = iServiceAgency.createAgency(a);
        return ResponseEntity.ok(ag);
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
