package com.example.shinhanserver.domain.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class FormDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FormRequestDto {
        private String name;
        private String phoneNumber;
        private String email;
        private String imageUrl;
        private String introduction;
        private List<String> specializationList;
        private List<CertificationDto> certificateList;
        private List<CareerDto> careerList;
        private List<EducationDto> educationList;
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

//    @Getter
//    @Builder
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class SpecializationDto {
//        private String field;
//    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CareerDto {
        private String company;
        private String department;
        private LocalDate startDate;
        private LocalDate endDate;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EducationDto {
        private String school;
        private String department;
        private LocalDate startDate;
        private LocalDate endDate;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FormResponseDto {
        private Long formId;
        private String message;
    }

}
