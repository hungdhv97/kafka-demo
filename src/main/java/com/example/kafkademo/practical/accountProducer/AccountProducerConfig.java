package com.example.kafkademo.practical.accountProducer;

import com.example.kafkademo.practical.dto.Account;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.RoundRobinPartitioner;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class AccountProducerConfig {

  @Value("${spring.kafka.properties.bootstrap.servers}")
  private String bootstrapServer;

  @Bean
  public ProducerFactory<String, Account> producerFactory() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
    configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    configs.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, RoundRobinPartitioner.class);
    return new DefaultKafkaProducerFactory<>(configs);
  }

  @Bean
  public KafkaTemplate<String, Account> kafkaTemplate() {
    return new KafkaTemplate<>(this.producerFactory());
  }
}
