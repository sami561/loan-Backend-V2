package com.sami.microservice.appointementservice.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
public class NotificationProducer {

   KafkaTemplate<String, AppointmentNotificationRequest> kafkaTemplate;
  private static final Logger logger = LoggerFactory.getLogger(NotificationProducer.class);

  public NotificationProducer(KafkaTemplate<String, AppointmentNotificationRequest> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendNotification(AppointmentNotificationRequest request) {
    Message<AppointmentNotificationRequest> message = MessageBuilder
            .withPayload(request)
            .setHeader(TOPIC, "appointment-topic")
            .build();

    kafkaTemplate.send(message);
    logger.info("Notification sent for request: {}", request);
  }
}