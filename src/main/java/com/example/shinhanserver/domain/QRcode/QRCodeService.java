package com.example.shinhanserver.domain.QRcode;

import com.example.shinhanserver.domain.PB.PBDto;
import com.example.shinhanserver.domain.PB.PBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.shinhanserver.domain.entity.PB;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QRCodeService {

  private final PBService pbService;

  public byte[] generateQRCodeForPbId(Long pbId) throws IOException, WriterException {
    String apiURL = generateApiURL(pbId);

    Map<EncodeHintType, Object> hintMap = new HashMap<>();
    hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    hintMap.put(EncodeHintType.MARGIN, 2);

    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    BitMatrix bitMatrix = qrCodeWriter.encode(apiURL, BarcodeFormat.QR_CODE, 200, 200, hintMap);

    BufferedImage image = new BufferedImage(bitMatrix.getWidth(), bitMatrix.getHeight(), BufferedImage.TYPE_INT_RGB);
    image.createGraphics();

    Graphics2D graphics = (Graphics2D) image.getGraphics();
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0, 0, bitMatrix.getWidth(), bitMatrix.getHeight());
    graphics.setColor(Color.BLACK);

    for (int x = 0; x < bitMatrix.getWidth(); x++) {
      for (int y = 0; y < bitMatrix.getHeight(); y++) {
        if (bitMatrix.get(x, y)) {
          graphics.fillRect(x, y, 1, 1);
        }
      }
    }

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ImageIO.write(image, "png", byteArrayOutputStream);

    return byteArrayOutputStream.toByteArray();
  }

  public PBDto.QRResponseDto getPBInfo(Long pbId) {
    PB pb = pbService.findPBById(pbId);
    return PBDto.QRResponseDto.builder()
            .id(pb.getId())
            .name(pb.getName())
            .phone(pb.getPhone())
            .email(pb.getEmail())
            .profile(pb.getProfile())
            //.specialization(pb.getSpecialization())
            .introduction(pb.getIntroduction())
            .cumulativeClientCount(pb.getCumulativeClientCount())
            .cumulativeTotalAmount(pb.getCumulativeTotalAmount())
            .cumulativeReturn(pb.getCumulativeReturn())
            .profit(pb.getProfit())
            .image(pb.getImage())
            .build();

  }

  private String generateApiURL(Long pbId) {
    return "http://localhost:8080/api/info/" + pbId;
  }
}