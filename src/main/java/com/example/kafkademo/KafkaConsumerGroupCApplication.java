package com.example.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.kafkademo.consumerGroupC")
public class KafkaConsumerGroupCApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaConsumerGroupCApplication.class, args);
  }
}
