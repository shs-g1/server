//package com.example.shinhanserver.domain.pbinfo;
//
//import com.example.shinhanserver.domain.PB.PBRepository;
//import com.example.shinhanserver.domain.entity.*;
//import com.example.shinhanserver.domain.form.CareerRepository;
//import com.example.shinhanserver.domain.form.CertificationRepository;
//import com.example.shinhanserver.domain.form.EducationRepository;
//import com.example.shinhanserver.domain.form.SpecializationRepository;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Service
//@AllArgsConstructor
//public class PBPageService {
//
//    private final PBRepository pbRepository;
//    private final CertificationRepository certificationRepository;
//    private final CareerRepository careerRepository;
//    private final EducationRepository educationRepository;
//    private final SpecializationRepository specializationRepository;
//
//    @Transactional(readOnly = true)
//    public PBPageDto.PBResponseDto getPBInfo(Long pbId) {
//        // PB 정보 조회
//        PB pb = pbRepository.findById(pbId)
//                .orElseThrow(() -> new RuntimeException("PB 정보를 찾을 수 없습니다. ID: " + pbId));
//
//        // Certification 정보 조회
//        List<Certification> certifications = certificationRepository.findByPb(pb);
//
//        // Career 정보 조회
//        List<Career> careers = careerRepository.findByPb(pb);
//
//        // Education 정보 조회
//        List<Education> educations = educationRepository.findByPb(pb);
//
//        // Specialization 정보 조회
//        List<Specialization> specializations = specializationRepository.findByPb(pb);
//
//        // PBResponseDto를 이용하여 응답 객체 생성
//        PBPageDto.PBResponseDto responseDto = PBPageDto.PBResponseDto.builder()
//                .name(pb.getName())
//                .phone(pb.getPhone())
//                .email(pb.getEmail())
//                .image(pb.getImage())
//                .selfIntroduction(pb.getIntroduction())
//                .cumulativeClientCount(pb.getCumulativeClientCount())
//                .cumulativeTotalAmount(pb.getCumulativeTotalAmount())
//                .cumulativeTotalProfit(pb.getCumulativeReturn())
//                .certifications(convertCertificationsToDto(certifications))
//                .careers(convertCareersToDto(careers))
//                .educations(convertEducationsToDto(educations))
//                .specializations(convertSpecializationsToDto(specializations))
//                .build();
//
//        return responseDto;
//    }
//
//    private List<PBPageDto.CertificationDto> convertCertificationsToDto(List<Certification> certifications) {
//        return certifications.stream()
//                .map(certification -> PBPageDto.CertificationDto.builder()
//                        .name(certification.getName())
//                        .publisher(certification.getPublisher())
//                        .date(certification.getDate())
//                        .build())
//                .collect(Collectors.toList());
//    }
//
//    private List<PBPageDto.CareerDto> convertCareersToDto(List<Career> careers) {
//        return careers.stream()
//                .map(career -> PBPageDto.CareerDto.builder()
//                        .organization(career.getOrganization())
//                        .location(career.getLocation())
//                        .startDate(career.getStartDate())
//                        .endDate(career.getEndDate())
//                        .build())
//                .collect(Collectors.toList());
//    }
//
//    private List<PBPageDto.EducationDto> convertEducationsToDto(List<Education> educations) {
//        return educations.stream()
//                .map(education -> PBPageDto.EducationDto.builder()
//                        .edu(education.getEdu())
//                        .major(education.getMajor())
//                        .startDate(education.getStartDate())
//                        .endDate(education.getEndDate())
//                        .build())
//                .collect(Collectors.toList());
//    }
//
//    private List<PBPageDto.SpecializationDto> convertSpecializationsToDto(List<Specialization> specializations) {
//        return specializations.stream()
//                .map(specialization -> PBPageDto.SpecializationDto.builder()
//                        .field1(specialization.getField1())
//                        .field2(specialization.getField2())
//                        .field3(specialization.getField3())
//                        .build())
//                .collect(Collectors.toList());
//    }
//}
//
