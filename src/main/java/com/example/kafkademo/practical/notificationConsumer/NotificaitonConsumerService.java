package com.example.kafkademo.practical.notificationConsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificaitonConsumerService {

  @KafkaListener(topics = "topic-demo", groupId = "notificationGroupId")
  public void listen(String message) {
    System.out.println("Consumer of GroupA received message from topic: " + message);
  }
}
