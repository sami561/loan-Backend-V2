package com.sami.microservice.clientservice.controller;

import com.sami.microservice.clientservice.entities.Client;
import com.sami.microservice.clientservice.service.IServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {
    private   IServiceClient iServiceClient;
    @GetMapping("/find/{id}")
    public ResponseEntity<Client> findClient(@PathVariable("id") int id){
        Client c = iServiceClient.findClientById(id);
        if (c==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(c);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Client>addClient(@RequestBody Client c){
        Client cl= iServiceClient.createClient(c);
        return ResponseEntity.ok(cl);
    }
    @PutMapping("/update")
    public ResponseEntity<Client>updateClient(@RequestBody Client c){
        Client cl = iServiceClient.updateClient(c);
        return ResponseEntity.ok(cl);
    }
    @DeleteMapping("/delete/{id}")
    public void  deleteClient(@PathVariable("id") int id){
    iServiceClient.deleteClient(id);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok(iServiceClient.findAllClient());
    }

}
