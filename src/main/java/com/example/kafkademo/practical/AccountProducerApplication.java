package com.example.kafkademo.practical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.kafkademo.practical.accountProducer")
public class AccountProducerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AccountProducerApplication.class, args);
  }
}
