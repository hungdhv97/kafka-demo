package com.example.kafkademo.consumerGroupB;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

  @KafkaListener(topics = "topic-demo", groupId = "group-b")
  public void listenOnTopic(String message) {
    System.out.println("Consumer3 GroupB received message from topic: " + message);
  }
}
