//package com.example.shinhanserver.service;
//
//import com.example.shinhanserver.domain.PB;
//import com.example.shinhanserver.dto.PBPageDto;
//import com.example.shinhanserver.repository.PBRepository;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityNotFoundException;
//
//@Slf4j
//@Service
//@AllArgsConstructor
//public class PBPageService {
//    private final PBRepository pbRepository;
//
//    public PBPageDto.PBResponseDto getPBPage(Long pbid) {
//        PB pb = pbRepository.findById(pbid)
//                .orElseThrow(() -> new EntityNotFoundException("PB not found with ID: " + pbid));
//
//
//    }
//}
