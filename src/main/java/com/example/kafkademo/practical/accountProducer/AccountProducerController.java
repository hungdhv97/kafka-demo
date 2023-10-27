package com.example.kafkademo.practical.accountProducer;

import com.example.kafkademo.practical.dto.Account;
import com.example.kafkademo.practical.dto.Message;
import com.example.kafkademo.practical.dto.Statistic;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/practical/")
public class AccountProducerController {

  @Autowired private AccountProducerService accountProducerService;

  @PostMapping("/send")
  public void sendAccountInfo(@RequestBody Account account) {
    final Message message =
        Message.builder()
            .email(account.getEmail())
            .username(account.getUsername())
            .subject("Kafka demo")
            .content("Hello everyone!!!!")
            .build();
    final Statistic statistic =
        Statistic.builder()
            .message("Account " + account.getEmail() + " is created")
            .createdDate(new Date())
            .build();

    this.accountProducerService.sendStatistic("statistic", statistic);
    this.accountProducerService.sendNotification("notification", message);
  }
}
