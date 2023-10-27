package com.example.kafkademo.example.consumerGroupA;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

  @KafkaListener(topics = "topic-demo", groupId = "group-a")
  public void listenOnTopic(String message) {
    System.out.println("Consumer of GroupA received message from topic: " + message);
  }
}
