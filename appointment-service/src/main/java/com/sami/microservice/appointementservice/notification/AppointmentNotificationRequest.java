package com.sami.microservice.appointementservice.notification;


import java.time.LocalDateTime;

public record AppointmentNotificationRequest(
        LocalDateTime dateRdv,
        String status

) {
}
