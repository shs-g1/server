package com.example.shinhanserver.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDto {
  private String code;
  private String name;
  private int amount;
  private double price;
}
