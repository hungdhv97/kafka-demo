package com.example.kafkademo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.kafkademo.example.producer")
public class KafkaProducerApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaProducerApplication.class, args);
  }
}
