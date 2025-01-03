package com.sami.microservice.notifsevice.kafka.appointment;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AppointmentConfirmation(
        LocalDateTime dateRdv,
        String status

) {
}
