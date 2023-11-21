package com.example.shinhanserver.domain.priceTrend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceTrendDto {
  private List<Integer> labels;
  private List<Double> profitRates;
}
