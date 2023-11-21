package com.example.shinhanserver.domain.pbinfo.service.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
    private String school;
    private String period;
}
