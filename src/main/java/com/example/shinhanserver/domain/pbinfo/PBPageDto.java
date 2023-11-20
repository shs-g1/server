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
        private int cumulativeClientCount; // PB Table -> cumulative_client_count, 포트폴리오마다의 고객 수 총합
        private int cumulativeTotalAmount; // PB Table -> cumulative_total_amount, 포트폴리오마다의 평가금액 총합
        private int cumulativeTotalProfit; // PB Table -> cumulative_return, 포트폴리오에 나타나는 수익률의 총합
        private List<PBPageDto.CertificationDto> certifications; // Certification Table
        private List<PBPageDto.CareerDto> careers; // Career Table
        private List<PBPageDto.EducationDto> educations; // Education Table
        private List<PBPageDto.SpecializationDto> specializations; // Specialization Table
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

}
