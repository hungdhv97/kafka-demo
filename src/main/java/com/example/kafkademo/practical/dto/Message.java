package com.example.kafkademo.practical.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Message {
  private final String email;
  private final String username;
  private final String subject;
  private final String content;
}
