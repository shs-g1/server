package com.example.shinhanserver.service;

import com.example.shinhanserver.domain.Career;
import com.example.shinhanserver.domain.Certification;
import com.example.shinhanserver.domain.Education;
import com.example.shinhanserver.domain.PB;
import com.example.shinhanserver.dto.FormDto;
import com.example.shinhanserver.repository.CareerRepository;
import com.example.shinhanserver.repository.CertificationRepository;
import com.example.shinhanserver.repository.EducationRepository;
import com.example.shinhanserver.repository.PBRepository;
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

    @Transactional
    public FormDto.FormResponseDto saveForm(FormDto.FormRequestDto formRequestDto) {
        // PB 저장
        PB pb = savePB(formRequestDto);

        // Certification 저장
        saveCertifications(formRequestDto.getCertifications(), pb);

        // Career 저장
        saveCareers(formRequestDto.getCareers(), pb);

        // Education 저장
        saveEducations(formRequestDto.getEducations(), pb);

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
                .phone(formRequestDto.getPhone())
                .email(formRequestDto.getEmail())
                .image(formRequestDto.getImage())
                .introduction(formRequestDto.getSelfIntroduction())
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
                    .organization(careerDto.getOrganization())
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
                    .edu(educationDto.getEdu())
                    .major(educationDto.getMajor())
                    .start_date(educationDto.getStartDate())
                    .end_date(educationDto.getEndDate())
                    .pb(pb)
                    .build();

            educationRepository.save(education);
        }
    }
}

