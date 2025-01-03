package com.sami.microservice.appointementservice.controller;

import com.sami.microservice.appointementservice.Model.Agency;
import com.sami.microservice.appointementservice.Model.Agent;
import com.sami.microservice.appointementservice.Model.Client;
import com.sami.microservice.appointementservice.clients.AgencyRestClient;
import com.sami.microservice.appointementservice.clients.AgentRestClient;
import com.sami.microservice.appointementservice.clients.ClientRestClient;
import com.sami.microservice.appointementservice.entities.Appointment;
import com.sami.microservice.appointementservice.service.IServiceAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
     IServiceAppointment iServiceAppointment;
    @Autowired
    AgentRestClient agentRestClient;
    @Autowired
    AgencyRestClient agencyRestClient;
    @Autowired
    ClientRestClient clientRestClient;
    @GetMapping("/find/{id}")
    public ResponseEntity<Appointment> findAppointment(@PathVariable("id") int id){
        Appointment a = iServiceAppointment.findAppointmentById(id);
        Optional<Client> client=clientRestClient.getClientById(a.getClientId());
        Optional<Agent> agent=agentRestClient.getAgentById(a.getAgentId());
        Optional<Agency> agency=agencyRestClient.getAgencyById(a.getAgencyId());
        a.setAgency(agency.get());
        a.setAgent(agent.get());
        a.setClient(client.get());

        if (a==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(a);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Object>addAppointment(@RequestBody Appointment a){
        Appointment ap=null;
        Optional<Client> client=clientRestClient.getClientById(a.getClientId());
        Optional<Agent> agent=agentRestClient.getAgentById(a.getAgentId());
        Optional<Agency> agency=agencyRestClient.getAgencyById(a.getAgencyId());
        if(client.isPresent()&& agent.isPresent() &&agency.isPresent())
            ap=iServiceAppointment.createAppointment(a) ;
        if(ap!=null)
             return new ResponseEntity<>(a, HttpStatus.CREATED);
       else
           return new ResponseEntity<>("appointment cant be created ",HttpStatus.CONFLICT);
    }
    @PutMapping("/update")
    public ResponseEntity<Appointment>updateAppointment(@RequestBody Appointment a){
        Appointment ap= iServiceAppointment.updateAppointment(a);
        return ResponseEntity.ok(ap);
    }
    @DeleteMapping("/delete/{id}")
    public void  deleteAppointment(@PathVariable("id") int id){
    iServiceAppointment.deleteAppointment(id);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> findAll(){
        return ResponseEntity.ok(iServiceAppointment.findAllAppointment());
    }

}
