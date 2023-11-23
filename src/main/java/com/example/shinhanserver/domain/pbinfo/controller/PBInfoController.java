package com.example.shinhanserver.domain.pbinfo.controller;

import com.example.shinhanserver.domain.pbinfo.service.PBInfoService;
import com.example.shinhanserver.domain.pbinfo.service.dto.PBResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class PBInfoController {

    private final PBInfoService pbInfoService;

    @GetMapping("/pbinfo")
    public ResponseEntity<?> getDetailInformation(@RequestParam Long pbId) {
        PBResponseDto response = pbInfoService.getPBInfo(pbId);
        return ResponseEntity.ok(response);
    }
}
