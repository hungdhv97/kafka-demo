package com.example.kafkademo.practical.notificationConsumer;

import com.example.kafkademo.practical.dto.Message;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
  public void sendEmail(Message message) {
    try {
      System.out.println("START---- Email sending to : " + message.getEmail());
      Thread.sleep(2000);
      System.out.println("END------ Email sent successfully to: " + message.getEmail());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
