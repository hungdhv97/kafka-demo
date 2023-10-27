package com.example.kafkademo.practical.notificationConsumer;

import com.example.kafkademo.practical.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificaitonConsumerService {

  @Autowired private EmailService emailService;

  @KafkaListener(topics = "notification", groupId = "notificationGroupId")
  public void listen(Message message) {
    System.out.println("Received: " + message.getEmail());
    this.emailService.sendEmail(message);
  }
}
