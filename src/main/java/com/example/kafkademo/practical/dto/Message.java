package com.example.kafkademo.practical.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder
@Data
public class Message {
  private final String email;
  private final String username;
  private final String subject;
  private final String content;

  @JsonCreator
  public Message(
      @JsonProperty("email") String email,
      @JsonProperty("username") String username,
      @JsonProperty("subject") String subject,
      @JsonProperty("content") String content) {
    this.email = email;
    this.username = username;
    this.subject = subject;
    this.content = content;
  }
}
