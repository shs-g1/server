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
public class PortfolioDto {
    private List<Long> portfolioID;
    private List<String> portfolioNames;
    private List<Long> principals;
    private List<Long> returns;
    private List<Long> cumulativeRORs;
    private List<String> durations;
}
