package com.sami.microservice.appointementservice.repository;


import com.sami.microservice.appointementservice.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
