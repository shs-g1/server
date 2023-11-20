package com.example.shinhanserver.domain.pbinfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class PBPageDto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PBResponseDto {
        private String name; // PB Table -> name
        private String phone; // PB Table -> Phone
        private String email; // PB Table -> email
        private String image; // PB Table -> image
        private String selfIntroduction; // PB Table -> introduction
        private int cumulativeClientCount; // PB Table -> cumulative_client_count
        private int cumulativeTotalAmount; // PB Table -> cumulative_total_amount
        private int cumulativeTotalProfit; // PB Table -> cumulative_return
        private List<PBPageDto.CertificationDto> certifications; // Certification Table
        private List<PBPageDto.CareerDto> careers; // Career Table
        private List<PBPageDto.EducationDto> educations; // Education Table
        private List<PBPageDto.SpecializationDto> specializations; // Specialization Table
        private List<PBPageDto.PortfolioDto> portfolios; // Portfolio Table
        private List<PBPageDto.PortfolioDetailDto> portfolioDetails;

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SpecializationDto {
        private String field1;
        private String field2;
        private String field3;
    }


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CertificationDto {
        private String name;
        private String publisher;
        private LocalDate date;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CareerDto {
        private String organization;
        private String location;
        private LocalDate startDate;
        private LocalDate endDate;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EducationDto {
        private String edu;
        private String major;
        private LocalDate startDate;
        private LocalDate endDate;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PortfolioDetailDto {
        private List<String> labels;
        private List<String> productNames;
        private List<String> accumRoRs;
        private List<String> durations;
        private List<Long> ratios;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PortfolioDto {
        private List<String> portfolioNames;
        private List<Long> principals;
        private List<Long> returns;
        private List<Long> cumulativeRORs;
        private List<String> durations;
    }
}
