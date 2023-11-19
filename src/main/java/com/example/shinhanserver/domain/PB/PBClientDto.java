package com.example.shinhanserver.domain.PB;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PBClientDto {

  private Long id;
  private String name;
  private String phone;
  private String email;
  private double currentAsset;
  private double currentProfitRate;  // 현재 수익률
  private double targetProfitRate;   // 목표 수익률

}
