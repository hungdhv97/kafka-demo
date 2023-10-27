package com.example.kafkademo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.kafkademo.example.consumerGroupD")
public class KafkaConsumerGroupDApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaConsumerGroupDApplication.class, args);
  }
}
