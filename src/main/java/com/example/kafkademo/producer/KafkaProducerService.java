package com.example.kafkademo.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProducerService {

  @Autowired private KafkaTemplate<String, String> kafkaTemplate;

  public void sendToTopic(String topic, String message) {
    this.kafkaTemplate.send(topic, message);
  }

  public void sendToPartition(String topic, int partition, String key, String message) {
    ProducerRecord<String, String> record = new ProducerRecord<>(topic, partition, key, message);
    this.kafkaTemplate.send(record);
  }
}
