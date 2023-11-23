package com.example.shinhanserver.domain.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
  private List<String> accountNumberAndName;
  private int totalAssets;
  private int withdrawalAmount;

}
