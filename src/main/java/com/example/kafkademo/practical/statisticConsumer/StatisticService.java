package com.example.kafkademo.practical.statisticConsumer;

import com.example.kafkademo.practical.dto.Statistic;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {
  public void saveStatistic(Statistic statistic) {
    try {
      System.out.println("START---- Saving message to database: " + statistic.getMessage());
      Thread.sleep(2000);
      System.out.println("END------ Message saved to database successfully");
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
