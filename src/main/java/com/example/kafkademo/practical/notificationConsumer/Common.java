package com.example.kafkademo.practical.notificationConsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.JsonMessageConverter;

public class Common {
  @Bean
  JsonMessageConverter jsonMessageConverter() {
    return new JsonMessageConverter();
  }
}
