package com.example.kafkademo.example.consumerGroupC;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

  @KafkaListener(
      topicPartitions = {
        @TopicPartition(
            topic = "topic-demo",
            partitions = {"0"})
      },
      groupId = "group-c")
  public void listenOnPartition(String message) {
    System.out.println("Consumer of GroupC received message from partition 0: " + message);
  }
}
