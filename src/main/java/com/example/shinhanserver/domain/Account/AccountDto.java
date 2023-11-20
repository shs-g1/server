package com.example.shinhanserver.domain.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
  private String accountNumber;
  private int totalAssets;
  private int withdrawalAmount;
}
