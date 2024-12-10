package com.sami.microservice.appointementservice.repository;


import com.sami.microservice.appointementservice.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    Appointment findByAgentIdAndDateAppointment(int id, LocalDateTime ldt);
    Appointment findByClientIdAndDateAppointment(int id, LocalDateTime ldt);


}
