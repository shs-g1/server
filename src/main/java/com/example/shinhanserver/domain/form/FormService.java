package com.example.shinhanserver.domain.form;

import com.example.shinhanserver.domain.entity.*;
import com.example.shinhanserver.domain.PB.PBRepository;
import com.example.shinhanserver.domain.pbinfo.SpecializationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;


//@Slf4j
//@Service
//@AllArgsConstructor
//public class FormService {
//
//    private final CertificationRepository certificationRepository;
//    private final CareerRepository careerRepository;
//    private final EducationRepository educationRepository;
//    private final PBRepository pbRepository;
//    private final SpecializationRepository specializationRepository;
//
//    @Transactional
//    public FormDto.FormResponseDto saveForm(FormDto.FormRequestDto formRequestDto) {
//        // PB 저장
//        PB pb = savePB(formRequestDto);
//
//        // Specialization 저장
//        saveSpecializations(formRequestDto.getSpecializationList(), pb);
//
//        // Certification 저장
//        saveCertifications(formRequestDto.getCertificateList(), pb);
//
//        // Career 저장
//        saveCareers(formRequestDto.getCareerList(), pb);
//
//        // Education 저장
//        saveEducations(formRequestDto.getEducationList(), pb);
//
//
//        // 필요에 따라 추가적인 로직 수행
//
//        return FormDto.FormResponseDto.builder()
//                .formId(pb.getId())
//                .message("Form saved successfully")
//                .build();
//    }
//
//    private PB savePB(FormDto.FormRequestDto formRequestDto) {
//
//        // formRequestDto에서 필요한 정보를 추출하여 PB 엔터티에 저장
//        PB pb = PB.builder()
//                .name(formRequestDto.getName())
//                .phone(formRequestDto.getPhoneNumber())
//                .email(formRequestDto.getEmail())
//                .image(formRequestDto.getImageUrl())
//                .introduction(formRequestDto.getIntroduction())
//                .build();
//
//
//        // PB 엔터티를 저장
//        return pbRepository.save(pb);
//    }
//
//    private void saveCertifications(List<FormDto.CertificationDto> certificationDtos, PB pb) {
//        // CertificationDto 리스트를 Certification 엔터티로 변환하여 저장
//        for (FormDto.CertificationDto certificationDto : certificationDtos) {
//            Certification certification = Certification.builder()
//                    .name(certificationDto.getName())
//                    .publisher(certificationDto.getPublisher())
//                    .date(certificationDto.getDate())
//                    .pb(pb)
//                    .build();
//
//            certificationRepository.save(certification);
//        }
//    }
//
//    private void saveCareers(List<FormDto.CareerDto> careerDtos, PB pb) {
//        // CareerDto 리스트를 Career 엔터티로 변환하여 저장
//        for (FormDto.CareerDto careerDto : careerDtos) {
//            Career career = Career.builder()
//                    .organization(careerDto.getCompany())
//                    .position(careerDto.getDepartment())
//                    .start_date(careerDto.getStartDate())
//                    .end_date(careerDto.getEndDate())
//                    .pb(pb)
//                    .build();
//
//            careerRepository.save(career);
//        }
//    }
//
//    private void saveEducations(List<FormDto.EducationDto> educationDtos, PB pb) {
//        // EducationDto 리스트를 Education 엔터티로 변환하여 저장
//        for (FormDto.EducationDto educationDto : educationDtos) {
//            Education education = Education.builder()
//                    .edu(educationDto.getSchool())
//                    .major(educationDto.getDepartment())
//                    .start_date(educationDto.getStartDate())
//                    .end_date(educationDto.getEndDate())
//                    .pb(pb)
//                    .build();
//
//            educationRepository.save(education);
//        }
//    }
//
//    private void saveSpecializations(List<String> specializationDtos, PB pb) {
//        // SpecializationDto 리스트를 Specialization 엔터티로 변환하여 저장
//        for (String specializationDto : specializationDtos) {
//            Specialization specialization = Specialization.builder()
//                    .field(specializationDto)
//                    .pb(pb)
//                    .build();
//
//            specializationRepository.save(specialization);
//        }
//    }
//}

@Slf4j
@Service
@AllArgsConstructor
public class FormService {

    private final CertificationRepository certificationRepository;
    private final CareerRepository careerRepository;
    private final EducationRepository educationRepository;
    private final PBRepository pbRepository;
    private final SpecializationRepository specializationRepository;

    @Transactional
    public FormDto.FormResponseDto saveForm(FormDto.FormRequestDto formRequestDto) {
        // 폼에서 받아온 id로 PB 조회
        PB pb = pbRepository.findById(formRequestDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("PB not found with id: " + formRequestDto.getId()));

        // 기존 값들 삭제
        deleteCertifications(pb);
        deleteCareers(pb);
        deleteEducations(pb);
        deleteSpecializations(pb);

        // PB 업데이트
        updatePB(pb, formRequestDto);

        // Specialization 저장
        saveSpecializations(formRequestDto.getSpecializationList(), pb);

        // Certification 저장
        saveCertifications(formRequestDto.getCertificateList(), pb);

        // Career 저장
        saveCareers(formRequestDto.getCareerList(), pb);

        // Education 저장
        saveEducations(formRequestDto.getEducationList(), pb);

        // 필요에 따라 추가적인 로직 수행
        return FormDto.FormResponseDto.builder()
                .formId(pb.getId())
                .message("Form saved successfully")
                .build();
    }

    private void updatePB(PB pb, FormDto.FormRequestDto formRequestDto) {
        // 이력사항 업데이트
        pb.setName(formRequestDto.getName());
        pb.setPhone(formRequestDto.getPhoneNumber());
        pb.setEmail(formRequestDto.getEmail());
        pb.setImage(formRequestDto.getImageUrl());
        pb.setIntroduction(formRequestDto.getIntroduction());
        // 기타 필요한 필드들을 업데이트

        // PB 저장
        pbRepository.save(pb);
    }

    private void saveCertifications(List<FormDto.CertificationDto> certificationDtos, PB pb) {
        certificationDtos.stream()
                .map(certificationDto -> Certification.builder()
                        .name(certificationDto.getName())
                        .publisher(certificationDto.getPublisher())
                        .date(certificationDto.getDate())
                        .pb(pb)
                        .build())
                .forEach(certificationRepository::save);
    }

    private void saveCareers(List<FormDto.CareerDto> careerDtos, PB pb) {
        careerDtos.stream()
                .map(careerDto -> Career.builder()
                        .organization(careerDto.getCompany())
                        .position(careerDto.getDepartment())
                        .start_date(careerDto.getStartDate())
                        .end_date(careerDto.getEndDate())
                        .pb(pb)
                        .build())
                .forEach(careerRepository::save);
    }

    private void saveEducations(List<FormDto.EducationDto> educationDtos, PB pb) {
        educationDtos.stream()
                .map(educationDto -> Education.builder()
                        .edu(educationDto.getSchool())
                        .major(educationDto.getDepartment())
                        .start_date(educationDto.getStartDate())
                        .end_date(educationDto.getEndDate())
                        .pb(pb)
                        .build())
                .forEach(educationRepository::save);
    }

    private void saveSpecializations(List<String> specializationDtos, PB pb) {
        specializationDtos.stream()
                .map(specializationDto -> Specialization.builder()
                        .field(specializationDto)
                        .pb(pb)
                        .build())
                .forEach(specializationRepository::save);
    }


    // Certification 엔터티 삭제
    private void deleteCertifications(PB pb) {
        List<Certification> certifications = certificationRepository.findByPb(pb);
        certificationRepository.deleteAll(certifications);
    }

    // Career 엔터티 삭제
    private void deleteCareers(PB pb) {
        List<Career> careers = careerRepository.findByPb(pb);
        careerRepository.deleteAll(careers);
    }

    // Education 엔터티 삭제
    private void deleteEducations(PB pb) {
        List<Education> educations = educationRepository.findByPb(pb);
        educationRepository.deleteAll(educations);
    }

    // Specialization 엔터티 삭제
    private void deleteSpecializations(PB pb) {
        List<Specialization> specializations = specializationRepository.findByPb(pb);
        specializationRepository.deleteAll(specializations);
    }
}


