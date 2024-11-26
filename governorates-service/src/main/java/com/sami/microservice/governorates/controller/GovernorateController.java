package com.sami.microservice.governorates.controller;

import com.sami.microservice.governorates.entites.Governorate;
import com.sami.microservice.governorates.service.IGovernoratesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/governorate")
@AllArgsConstructor
public class GovernorateController {
    private final IGovernoratesService iGovernoratesService;
    @GetMapping("/find/{id}")
    public ResponseEntity<Governorate> findGovernorate(@PathVariable("id") int id){
        Governorate d = iGovernoratesService.findGovernorateById(id);
        if (d==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(d);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Governorate>addGovernorate(@RequestBody Governorate g){
        Governorate gov = iGovernoratesService.createGovernorate(g);
        return ResponseEntity.ok(gov);
    }
    @PutMapping("/update")
    public ResponseEntity<Governorate>updateGovernorate(@RequestBody Governorate g){
        Governorate gov = iGovernoratesService.updateGovernorate(g);
        return ResponseEntity.ok(gov);
    }
    @DeleteMapping("/delete/{id}")
    public void  deleteGovernorate(@PathVariable("id") int id){
        iGovernoratesService.deleteGovernorate(id);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Governorate>> findAll(){
        return ResponseEntity.ok(iGovernoratesService.findAllGovernorate());
    }
}
