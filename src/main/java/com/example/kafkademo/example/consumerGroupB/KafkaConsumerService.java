package com.example.kafkademo.example.consumerGroupB;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

  @KafkaListener(topics = "topic-demo", groupId = "group-b")
  public void listen1OnTopic(String message) {
    System.out.println("Consumer1 GroupB received message from topic: " + message);
  }

  @KafkaListener(topics = "topic-demo", groupId = "group-b")
  public void listen2OnTopic(String message) {
    System.out.println("Consumer2 GroupB received message from topic: " + message);
  }
}
