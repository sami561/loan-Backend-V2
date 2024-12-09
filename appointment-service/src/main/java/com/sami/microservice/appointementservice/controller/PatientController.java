package com.sami.microservice.appointementservice.controller;

import com.sami.microservice.appointementservice.entities.Appointment;
import com.sami.microservice.appointementservice.service.IServiceAppointment;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@AllArgsConstructor
public class PatientController {
    private   IServiceAppointment iServiceAppointment;
    @GetMapping("/find/{id}")
    public ResponseEntity<Appointment> findAppointment(@PathVariable("id") int id){
        Appointment a = iServiceAppointment.findAppointmentById(id);
        if (a==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(a);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Appointment>addAppointment(@RequestBody Appointment a){
        Appointment al = iServiceAppointment.createAppointment(a);
        return ResponseEntity.ok(al);
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
