package com.example.kafkademo.practical.accountProducer;

import com.example.kafkademo.practical.dto.Message;
import com.example.kafkademo.practical.dto.Statistic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AccountProducerService {

  @Autowired private KafkaTemplate<String, Object> kafkaTemplate;

  public void sendNotification(String topic, Message message) {
    this.kafkaTemplate.send(topic, message);
  }

  public void sendStatistic(String topic, Statistic statistic) {
    this.kafkaTemplate.send(topic, statistic);
  }
}
