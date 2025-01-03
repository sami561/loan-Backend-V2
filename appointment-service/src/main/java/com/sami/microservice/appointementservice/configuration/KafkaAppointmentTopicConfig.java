package com.sami.microservice.appointementservice.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaAppointmentTopicConfig {

  @Bean
  public NewTopic appointmentTopic() {
    return TopicBuilder
            .name("appointment-topic")
            .build();
  }
}
