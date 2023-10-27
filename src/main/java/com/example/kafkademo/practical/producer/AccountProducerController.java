package com.example.kafkademo.practical.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
public class AccountProducerController {

  @Autowired private AccountProducerService accountProducerService;

  @PostMapping("/send-to-topic")
  public String sendMessage(@RequestParam String topic, @RequestBody String message) {
    this.accountProducerService.send(topic, message);
    return "Message sent successfully";
  }
}
