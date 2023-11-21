package com.example.shinhanserver.domain.pbinfo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioDetailDto {
    private List<String> labels;
    private List<String> productNames;
    private List<Long> realizedGainLoss;
    private List<Long> evaluatePrice;
    private List<Double> accumRoRs;
    private List<String> durations;
    private List<Double> ratios;
}
