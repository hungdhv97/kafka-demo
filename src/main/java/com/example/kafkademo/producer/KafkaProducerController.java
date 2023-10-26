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

  @PostMapping("/send")
  public String sendMessage(@RequestParam String topic, @RequestBody String message) {
    this.kafkaProducerService.sendToTopic(topic, message);
    return "Message sent successfully";
  }

  @PostMapping("/sendToPartition")
  public String sendToPartition(
      @RequestParam String topic,
      @RequestParam int partition,
      @RequestParam String key,
      @RequestBody String message) {
    this.kafkaProducerService.sendToPartition(topic, partition, key, message);
    return "Message sent to partition successfully";
  }
}
