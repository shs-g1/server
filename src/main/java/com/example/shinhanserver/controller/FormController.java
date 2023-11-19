package com.example.shinhanserver.controller;

import com.example.shinhanserver.dto.FormDto;
import com.example.shinhanserver.dto.LoginDto;
import com.example.shinhanserver.response.ResponseDto;
import com.example.shinhanserver.service.FormService;
import com.example.shinhanserver.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/form")
public class FormController {
    private final FormService formService;

    @PostMapping
    public ResponseEntity<ResponseDto> addCertification(@RequestBody FormDto.FormRequestDto formRequestDto) {
        try {
            FormDto.FormResponseDto formResponseDto = formService.saveForm(formRequestDto);

            Map<String, Object> payload = new HashMap<>();
            payload.put("certification", formResponseDto);

            ResponseDto responseBody = ResponseDto.builder()
                    .payload(payload)
                    .build();

            return ResponseEntity.ok(responseBody);
        } catch (RuntimeException e) {
            ResponseDto errorResponse = ResponseDto.builder()
                    .error("폼이 정상적으로 제출되지 못했습니다.")
                    .build();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
