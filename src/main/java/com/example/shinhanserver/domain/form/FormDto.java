package com.example.shinhanserver.domain.form;

import com.example.shinhanserver.domain.entity.Specialization;
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
        private String phone;
        private String email;
        private String image;
        private String selfIntroduction;
        private List<SpecializationDto> specialization;
        private List<CertificationDto> certifications;
        private List<CareerDto> careers;
        private List<EducationDto> educations;
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
    public static class SpecializationDto {
        private String field;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CareerDto {
        private String organization;
        private String position;
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
    public static class FormResponseDto {
        private Long formId;
        private String message;
    }

}