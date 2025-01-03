package com.sami.microservice.notifsevice.kafka;

import com.sami.microservice.notifsevice.email.EmailService;
import com.sami.microservice.notifsevice.kafka.appointment.AppointmentConfirmation;
import com.sami.microservice.notifsevice.notification.Notification;
import com.sami.microservice.notifsevice.notification.NotificationRepository;
import jakarta.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.sami.microservice.notifsevice.notification.NotificationType.Appointment_CONFIRMATION;
import static java.lang.String.format;

@Service
public class NotificationsConsumer {

    private static final Logger log = LoggerFactory.getLogger(NotificationsConsumer.class);

    private final NotificationRepository repository;
    private final EmailService emailService;

    public NotificationsConsumer(NotificationRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    @KafkaListener(topics = "appointment-topic")
    public void consumeOrderConfirmationNotifications(AppointmentConfirmation appointmentConfirmation) throws MessagingException {
        log.info(format("Consuming the message from order-topic Topic:: %s", appointmentConfirmation));

        repository.save(
                Notification.builder()
                        .type(Appointment_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .appointmentConfirmation(appointmentConfirmation)
                        .build()
        );



        emailService.sendAppointmentConfirmationEmail(
          appointmentConfirmation.dateRdv(),
                appointmentConfirmation.status()

        );
    }
}
