package com.example.shinhanserver.domain.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {
  private Long id;
  private String name;
  private String phone;
  private String email;
  private String type;
  private double currentProfitRate;  // 현재 수익률
  private double profits;        // 손익 금액
  private double totalAssets;    // 자산 총액
}
