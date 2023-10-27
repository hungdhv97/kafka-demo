package com.example.kafkademo.practical.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder
@Data
public class Statistic {
  private final String message;
  private final Date createdDate;

  @JsonCreator
  public Statistic(
      @JsonProperty("message") String message, @JsonProperty("createdDate") Date createdDate) {
    this.message = message;
    this.createdDate = createdDate;
  }
}
