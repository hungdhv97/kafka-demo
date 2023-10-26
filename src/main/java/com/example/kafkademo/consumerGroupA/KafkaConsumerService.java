package com.example.kafkademo.consumerGroupA;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

  @KafkaListener(topics = "topic-demo", groupId = "group-a")
  public void listenOnTopic1(String message) {
    System.out.println("Consumer1 GroupA received message from topic: " + message);
  }

  @KafkaListener(topics = "topic-demo", groupId = "group-a")
  public void listenOnTopic2(String message) {
    System.out.println("Consumer2 GroupA received message from topic: " + message);
  }
}
