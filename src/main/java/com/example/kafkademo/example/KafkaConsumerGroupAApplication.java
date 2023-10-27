package com.example.kafkademo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.kafkademo.example.consumerGroupA")
public class KafkaConsumerGroupAApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaConsumerGroupAApplication.class, args);
  }
}
