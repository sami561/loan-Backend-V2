package com.sami.microservice.appointementservice.service;


import com.sami.microservice.appointementservice.entities.Appointment;
import com.sami.microservice.appointementservice.repository.AppointmentRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceAppointment implements IServiceAppointment {
    public  AppointmentRepository appointmentRepository;
    @Override
    public Appointment createAppointment(Appointment a) {
        return appointmentRepository.save(a);
    }

    @Override
    public Appointment findAppointmentById(int id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public List<Appointment> findAllAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment updateAppointment(Appointment a) {
        return appointmentRepository.save(a);
    }

    @Override
    public void deleteAppointment(int id) {
        appointmentRepository.deleteById(id);
    }
}
