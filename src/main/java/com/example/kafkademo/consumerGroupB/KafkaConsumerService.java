package com.example.kafkademo.consumerGroupB;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

  @KafkaListener(topics = "topic-demo", groupId = "group-b")
  public void listenOnTopic1(String message) {
    System.out.println("Consumer1 GroupB received message from topic: " + message);
  }

  @KafkaListener(topics = "topic-demo", groupId = "group-b")
  public void listenOnTopic2(String message) {
    System.out.println("Consumer2 GroupB received message from topic: " + message);
  }
}
