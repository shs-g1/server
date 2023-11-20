package com.example.shinhanserver.domain.QRcode;

import com.example.shinhanserver.domain.PB.PBDto;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QRCodeController {

  private final QRCodeService qrCodeService;

  // QR 코드 생성하기
  @GetMapping(value = "/qr/{pbId}", produces = MediaType.IMAGE_PNG_VALUE)
  public byte[] generateQRCode(@PathVariable Long pbId) throws IOException, WriterException {
    return qrCodeService.generateQRCodeForPbId(pbId);
  }

  // QR 코드 정보 가져오기
  @GetMapping(value = "/info/{pbId}")
  public PBDto.QRResponseDto getPBInfo(@PathVariable Long pbId) {
    return qrCodeService.getPBInfo(pbId);
  }

}