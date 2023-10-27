package com.example.kafkademo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.kafkademo.example.consumerGroupB")
public class KafkaConsumerGroupBApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaConsumerGroupBApplication.class, args);
  }
}
