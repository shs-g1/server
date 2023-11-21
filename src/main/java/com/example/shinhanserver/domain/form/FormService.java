package com.example.shinhanserver.domain.form;

import com.example.shinhanserver.domain.entity.*;
import com.example.shinhanserver.domain.PB.PBRepository;
import com.example.shinhanserver.domain.pbinfo.SpecializationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
        // PB 저장
        PB pb = savePB(formRequestDto);

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

    private PB savePB(FormDto.FormRequestDto formRequestDto) {
        // formRequestDto에서 필요한 정보를 추출하여 PB 엔터티에 저장
        PB pb = PB.builder()
                .name(formRequestDto.getName())
                .phone(formRequestDto.getPhoneNumber())
                .email(formRequestDto.getEmail())
                .image(formRequestDto.getImageUrl())
                .introduction(formRequestDto.getIntroduction())
                .build();


        // PB 엔터티를 저장
        return pbRepository.save(pb);
    }

    private void saveCertifications(List<FormDto.CertificationDto> certificationDtos, PB pb) {
        // CertificationDto 리스트를 Certification 엔터티로 변환하여 저장
        for (FormDto.CertificationDto certificationDto : certificationDtos) {
            Certification certification = Certification.builder()
                    .name(certificationDto.getName())
                    .publisher(certificationDto.getPublisher())
                    .date(certificationDto.getDate())
                    .pb(pb)
                    .build();

            certificationRepository.save(certification);
        }
    }

    private void saveCareers(List<FormDto.CareerDto> careerDtos, PB pb) {
        // CareerDto 리스트를 Career 엔터티로 변환하여 저장
        for (FormDto.CareerDto careerDto : careerDtos) {
            Career career = Career.builder()
                    .organization(careerDto.getCompany())
                    .position(careerDto.getDepartment())
                    .start_date(careerDto.getStartDate())
                    .end_date(careerDto.getEndDate())
                    .pb(pb)
                    .build();

            careerRepository.save(career);
        }
    }

    private void saveEducations(List<FormDto.EducationDto> educationDtos, PB pb) {
        // EducationDto 리스트를 Education 엔터티로 변환하여 저장
        for (FormDto.EducationDto educationDto : educationDtos) {
            Education education = Education.builder()
                    .edu(educationDto.getSchool())
                    .major(educationDto.getDepartment())
                    .start_date(educationDto.getStartDate())
                    .end_date(educationDto.getEndDate())
                    .pb(pb)
                    .build();

            educationRepository.save(education);
        }
    }

    private void saveSpecializations(List<String> specializationDtos, PB pb) {
        // SpecializationDto 리스트를 Specialization 엔터티로 변환하여 저장
        for (String specializationDto : specializationDtos) {
            Specialization specialization = Specialization.builder()
                    .field(specializationDto)
                    .pb(pb)
                    .build();

            specializationRepository.save(specialization);
        }
    }
}

