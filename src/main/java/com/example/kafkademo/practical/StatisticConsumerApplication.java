package com.example.kafkademo.practical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.kafkademo.practical.statisticConsumer")
public class StatisticConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(StatisticConsumerApplication.class, args);
  }
}
