package com.example.kafkademo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
public class KafkaProducerController {

  @Autowired private KafkaProducerService kafkaProducerService;

  @PostMapping("/send-to-topic")
  public String sendMessage(@RequestParam String topic, @RequestBody String message) {
    this.kafkaProducerService.sendToTopic(topic, message);
    return "Message sent successfully";
  }

  @PostMapping("/send-to-partition")
  public String sendToPartition(
      @RequestParam String topic,
      @RequestParam(required = false) Integer partition,
      @RequestParam(required = false) String key,
      @RequestBody String message) {
    this.kafkaProducerService.sendToPartition(topic, partition, key, message);
    return "Message sent to partition successfully";
  }

  @PostMapping("/send-to-topic/messages")
  public String sendMultipleMessagesToTopic(
      @RequestParam String topic, @RequestParam int numMessages) {
    for (int i = 1; i <= numMessages; i++) {
      String message = "Message " + i;
      this.kafkaProducerService.sendToTopic(topic, message);
    }
    return "Sent " + numMessages + " messages to topic successfully";
  }

  @PostMapping("/send-to-partition/messages")
  public String sendMultipleMessagesToPartition(
      @RequestParam String topic,
      @RequestParam(required = false) Integer partition,
      @RequestParam(required = false) String key,
      @RequestParam int numMessages) {
    for (int i = 1; i <= numMessages; i++) {
      String message = "Message " + i;
      this.kafkaProducerService.sendToPartition(topic, partition, key, message);
    }
    return "Sent " + numMessages + " messages to partition successfully";
  }

  @PostMapping("multi/send-to-topic/messages")
  public String sendMultipleProducersSendMultipleMessagesToTopic(
      @RequestParam String topic, @RequestParam int numProducers, @RequestParam int numMessages) {
    for (int i = 0; i < numProducers; i++) {
      int i1 = i;
      new Thread(
              () -> {
                for (int j = 1; j <= numMessages; j++) {
                  String message = "Producer " + i1 + " Message " + j;
                  this.kafkaProducerService.sendToTopic(topic, message);
                }
              })
          .start();
    }
    return numProducers + " producers started successfully";
  }
}
