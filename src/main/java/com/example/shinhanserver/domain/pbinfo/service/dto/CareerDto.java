package com.example.shinhanserver.domain.pbinfo.service.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CareerDto {
    private String position;
    private String company;
    private String period;
}
