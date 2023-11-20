package com.example.shinhanserver.domain.pbinfo.service.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PBResponseDto {
    private String name; // PB Table -> name

    private String imageUrl; // PB Table -> image

    private String tel; // PB Table -> Phone
    private String email; // PB Table -> email
    private String current;

    private List<String> specialization; // Specialization Table

    private int customers; // PB Table -> cumulative_client_count
    private double totalAmount; // PB Table -> cumulative_total_amount
    private double profitMargin; // PB Table -> cumulative_return

    private String introduction; // PB Table -> introduction

    private List<CareerDto> experience; // Career Table

    private List<EducationDto> education; // Education Table

    private List<String> certificates; // Certification Table

    // Portfolio
    private List<Long> portfolioID;
    private List<String> portfolioNames;
    private List<Long> principals;
    private List<Long> returns;
    private List<Double> cumulativeRORs;
    private List<String> durations;

}
