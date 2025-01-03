package com.sami.microservice.notifsevice.notification;


import com.sami.microservice.notifsevice.kafka.appointment.AppointmentConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Notification {

    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private AppointmentConfirmation appointmentConfirmation;

}
