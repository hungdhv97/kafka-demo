package com.example.kafkademo.practical.statisticConsumer;

import com.example.kafkademo.practical.dto.Statistic;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class StatisticConsumerConfig {

  @Value("${spring.kafka.properties.bootstrap.servers}")
  private String bootstrapServers;

  @Bean
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "statisticGroupId");
    return props;
  }

  @Bean
  public ConsumerFactory<String, Statistic> consumerFactory() {
    Map<String, Object> consumerProps = consumerConfigs();
    return new DefaultKafkaConsumerFactory<>(
        consumerProps, new StringDeserializer(), new JsonDeserializer<>(Statistic.class, false));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Statistic>
      kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Statistic> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }
}
