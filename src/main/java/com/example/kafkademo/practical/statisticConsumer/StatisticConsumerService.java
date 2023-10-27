package com.example.kafkademo.practical.statisticConsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StatisticConsumerService {

  @KafkaListener(topics = "topic-demo", groupId = "statisticGroupId")
  public void listen(String message) {
    System.out.println("Consumer of GroupA received message from topic: " + message);
  }
}
