package com.example.kafkademo.practical.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AccountProducerService {

  @Autowired private KafkaTemplate<String, String> kafkaTemplate;

  public void send(String topic, String message) {
    this.kafkaTemplate.send(topic, message);
  }
}
