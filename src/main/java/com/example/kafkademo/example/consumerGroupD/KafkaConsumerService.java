package com.example.kafkademo.example.consumerGroupD;

import java.util.List;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

  @KafkaListener(topics = "topic-demo", groupId = "group-d")
  public void listenOnTopic(List<String> messages) {
    System.out.println("Batch messages size: " + messages.size());
    for (String message : messages) {
      System.out.println("Received Message: " + message);
    }
  }

  //  @KafkaListener(
  //      topicPartitions = {
  //        @TopicPartition(
  //            topic = "topic-demo",
  //            partitions = {"0"})
  //      },
  //      groupId = "group-d")
  //  public void listenOnPartition(List<String> messages) {
  //    System.out.println("Batch messages size: " + messages.size());
  //    for (String message : messages) {
  //      System.out.println("Received Message: " + message);
  //    }
  //  }
}
