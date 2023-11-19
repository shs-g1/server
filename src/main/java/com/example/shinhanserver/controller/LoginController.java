package com.example.shinhanserver.controller;

import com.example.shinhanserver.dto.LoginDto;
import com.example.shinhanserver.response.ResponseDto;
import com.example.shinhanserver.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginDto.LoginRequestDto loginDto) {
        try {
            LoginDto.LoginResponseDto loginResponseDto = loginService.login(loginDto);

            Map<String, Object> payload = new HashMap<>();
            payload.put("login", loginResponseDto);

            ResponseDto responseBody = ResponseDto.builder()
                    .payload(payload)
                    .build();

            return ResponseEntity.ok(responseBody);
        } catch (RuntimeException e) {
            ResponseDto errorResponse = ResponseDto.builder()
                    .error("로그인 실패했습니다.")
                    .build();

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}
