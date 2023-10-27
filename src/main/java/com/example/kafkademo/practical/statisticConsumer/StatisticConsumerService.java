package com.example.kafkademo.practical.statisticConsumer;

import com.example.kafkademo.practical.dto.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StatisticConsumerService {
  @Autowired private StatisticService statisticService;

  @KafkaListener(topics = "statistic", groupId = "statisticGroupId")
  public void listen(Statistic statistic) {
    System.out.println("Received: " + statistic.getMessage());
    this.statisticService.saveStatistic(statistic);
  }
}
