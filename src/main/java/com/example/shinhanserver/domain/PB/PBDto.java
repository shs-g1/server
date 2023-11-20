package com.example.shinhanserver.domain.PB;

import lombok.*;

public class PBDto {
  @Getter
  @Setter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class QRResponseDto{
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String profile;
    private String specialization;
    private String introduction;
    private int cumulativeClientCount;
    private double cumulativeTotalAmount;
    private double cumulativeReturn;
    private double profit;
    private String image;

  }
}