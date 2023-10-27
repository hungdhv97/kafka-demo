package com.example.kafkademo.practical.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Account {
  private final String email;
  private final String username;
}
