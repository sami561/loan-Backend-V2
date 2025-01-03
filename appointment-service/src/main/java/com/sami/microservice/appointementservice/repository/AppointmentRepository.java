package com.sami.microservice.appointementservice.repository;


import com.sami.microservice.appointementservice.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
  Appointment findByAgentIdAndDateRdv(int agentId, LocalDateTime dateRdv);

    // Find all appointments for a client at a specific date and time
    Appointment findByClientIdAndDateRdv(int clientId, LocalDateTime dateRdv);


}
