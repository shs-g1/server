package com.example.shinhanserver.service;

import com.example.shinhanserver.domain.PB;
import com.example.shinhanserver.dto.LoginDto;
import com.example.shinhanserver.repository.PBRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class LoginService {

    private final PBRepository pbRepository;

//    @Transactional
//    public LoginDto.LoginResponseDto login(LoginDto.LoginRequestDto loginDto) {
////        PB pb = pbRepository.findByLoginIdAndLoginPw(loginDto.getLoginId(), loginDto.getLoginPw())
////                .orElseThrow(() -> new RuntimeException("Invalid login credentials"));
//
//        PB pb = pbRepository.findByLoginId(loginDto.getLoginId())
//                .orElseThrow(() -> new RuntimeException("Invalid login credentials");
//
//        if (!passwordEncoder.matches(loginDto.getLoginPw(), pb.getLoginPw())) {
//            throw new RuntimeException("Invalid password");
//        }
//
//        return LoginDto.LoginResponseDto.builder()
//                .pbId(pb.getId())
//                .build();
//    }
    @Transactional
    public LoginDto.LoginResponseDto login(LoginDto.LoginRequestDto loginDto) {
        PB pb = pbRepository.findByLoginId(loginDto.getLoginId())
                .orElseThrow(() -> new RuntimeException("Invalid login credentials"));

        if (loginDto.getLoginPw().equals(pb.getLoginPw())) {
            return LoginDto.LoginResponseDto.builder()
                    .pbId(pb.getId())
                    .message("로그인 성공")
                    .build();
        } else {
            throw new RuntimeException("Invalid password");
        }
    }
}

