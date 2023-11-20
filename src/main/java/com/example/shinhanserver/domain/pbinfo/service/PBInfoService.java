package com.example.shinhanserver.domain.pbinfo.service;

import com.example.shinhanserver.domain.PB.PBRepository;
import com.example.shinhanserver.domain.entity.*;
import com.example.shinhanserver.domain.form.CareerRepository;
import com.example.shinhanserver.domain.form.CertificationRepository;
import com.example.shinhanserver.domain.form.EducationRepository;
import com.example.shinhanserver.domain.pbinfo.PortfolioRepository;
import com.example.shinhanserver.domain.pbinfo.SpecializationRepository;
import com.example.shinhanserver.domain.pbinfo.TransactionRepository;
import com.example.shinhanserver.domain.pbinfo.service.dto.CareerDto;
import com.example.shinhanserver.domain.pbinfo.service.dto.EducationDto;
import com.example.shinhanserver.domain.pbinfo.service.dto.PBResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Service
public class PBInfoService {
    private final PBRepository pbRepository;
    private final CertificationRepository certificationRepository;
    private final CareerRepository careerRepository;
    private final EducationRepository educationRepository;
    private final SpecializationRepository specializationRepository;
    private final PortfolioRepository portfolioRepository;
    private final TransactionRepository transactionRepository;

    public PBResponseDto getPBInfo(Long pbId) {
        PB pb = pbRepository.findById(pbId)
                .orElseThrow(() -> new EntityNotFoundException("PB not found with ID: " + pbId));

        List<Certification> certificationList = certificationRepository.findAllByPb(pb);
        List<Career> careerList = careerRepository.findAllByPb(pb);
        List<Education> educationList = educationRepository.findAllByPb(pb);
        List<Specialization> specializationList = specializationRepository.findAllByPb(pb);
        List<Portfolio> portfolioList = portfolioRepository.findAllByPb(pb);

        List<String> specialization = specializationList.stream()
                .map(Specialization::getField)
                .collect(Collectors.toList());

        String current = null;
        int tmp_year=0;
        List<CareerDto> experience = new ArrayList<>();
        for (Career career : careerList) {
            String startYear = String.valueOf(career.getStart_date().getYear());
            String endYear = String.valueOf(career.getEnd_date().getYear());
            String period = startYear + " - " + endYear;
            
            if (tmp_year <= career.getEnd_date().getYear()) {
                current = career.getOrganization() + " " + career.getPosition();
                tmp_year = career.getEnd_date().getYear();
            }

            CareerDto careerDto = new CareerDto(
                    career.getPosition(),
                    career.getOrganization(),
                    period
            );
            experience.add(careerDto);            
        }

        List<EducationDto> education = new ArrayList<>();
        for (Education edu : educationList) {
            String startYear = String.valueOf(edu.getStart_date().getYear());
            String endYear = String.valueOf(edu.getEnd_date().getYear());
            String period = startYear + " - " + endYear;

            EducationDto educationDto = new EducationDto(
                    edu.getEdu(),
                    period
            );

            education.add(educationDto);
        }

        List<String> certificates = certificationList.stream()
                .map(Certification::getName)
                .collect(Collectors.toList());


        List<Long> portfolioID = new ArrayList<>();
        List<String> portfolioNames = new ArrayList<>();
        List<Long> principals = new ArrayList<>();
        List<Long> returns = new ArrayList<>();
        List<Double> cumulativeRORs = new ArrayList<>();
        List<String> durations = new ArrayList<>();

        for (Portfolio portfolio: portfolioList) {

            List<Transaction> buyTransactionList = transactionRepository.findAllByPortfolioAndTransactionType(portfolio,"매수");
            List<Transaction> sellTransactionList = transactionRepository.findAllByPortfolioAndTransactionType(portfolio,"매도");

            if (buyTransactionList.size() == sellTransactionList.size()){
                portfolioID.add(portfolio.getId());
                portfolioNames.add(portfolio.getName());
                long principal = 0;
                long sellPrice = 0;
                LocalDate oldestStartDate = LocalDate.MAX;
                LocalDate latestEndDate = LocalDate.MIN;
                for (Transaction buyTx: buyTransactionList) {
                    principal += buyTx.getPrice();
                    if (buyTx.getTransactionDate().isBefore(oldestStartDate)){
                        oldestStartDate = buyTx.getTransactionDate();
                    }
                }
                for (Transaction sellTx: sellTransactionList) {
                    sellPrice += sellTx.getPrice();
                    if (sellTx.getTransactionDate().isAfter(latestEndDate)){
                        latestEndDate = sellTx.getTransactionDate();
                    }
                }
                principals.add(principal);
                returns.add(sellPrice-principal);
                cumulativeRORs.add(((sellPrice-principal)/principal * 100.0));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedStart = oldestStartDate.format(formatter);
                String formattedEnd = latestEndDate.format(formatter);
                String period = formattedStart + " - " + formattedEnd;

                durations.add(period);
            }
        }

        List<Long> sortedReturns = new ArrayList<>(returns);
        sortedReturns.sort(Collections.reverseOrder());

        List<Integer> top3Indexes = new ArrayList<>();
        for (int i=0; i < Math.min(3, sortedReturns.size()); i++) {
            top3Indexes.add(returns.indexOf(sortedReturns.get(i)));
        }

        List<Long> tmp_portfolioID = new ArrayList<>();
        List<String> tmp_portfolioNames = new ArrayList<>();
        List<Long> tmp_principals = new ArrayList<>();
        List<Long> tmp_returns = new ArrayList<>();
        List<Double> tmp_cumulativeRORs = new ArrayList<>();
        List<String> tmp_durations = new ArrayList<>();

        for(Integer i: top3Indexes){
            tmp_portfolioID.add(portfolioID.get(i));
            tmp_portfolioNames.add(portfolioNames.get(i));
            tmp_principals.add(principals.get(i));
            tmp_returns.add(principals.get(i));
            tmp_cumulativeRORs.add(cumulativeRORs.get(i));
            tmp_durations.add(durations.get(i));
        }

        return PBResponseDto.builder()
                .name(pb.getName())
                .tel(pb.getPhone())
                .email(pb.getEmail())
                .imageUrl(pb.getImage())
                .current(current)
                .specialization(specialization)
                .introduction(pb.getIntroduction())
                .customers(pb.getCumulativeClientCount())
                .totalAmount(pb.getCumulativeTotalAmount())
                .profitMargin(pb.getCumulativeReturn())
                .experience(experience)
                .education(education)
                .certificates(certificates)
                .portfolioID(tmp_portfolioID)
                .portfolioNames(tmp_portfolioNames)
                .principals(tmp_principals)
                .returns(tmp_returns)
                .cumulativeRORs(tmp_cumulativeRORs)
                .durations(tmp_durations)
                .build();
    }

}
