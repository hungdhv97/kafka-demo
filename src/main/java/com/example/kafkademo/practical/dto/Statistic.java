package com.example.kafkademo.practical.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Statistic {
  private final String message;
  private final Date createdDate;
}
