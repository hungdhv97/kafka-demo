package com.example.kafkademo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

  @KafkaListener(topics = "topic-demo", groupId = "my-group")
  public void listenOnTopic(String message) {
    System.out.println("Received message from topic: " + message);
  }

  @KafkaListener(
      topicPartitions =
          @TopicPartition(
              topic = "topic-demo",
              partitions = {"0"}),
      groupId = "my-group")
  public void listenOnPartition(String message) {
    System.out.println("Received message from partition 0: " + message);
  }
}
