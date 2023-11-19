package com.example.shinhanserver.domain.PB;

import java.util.*;

import com.example.shinhanserver.domain.client.Client;
import com.example.shinhanserver.domain.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PBService {
  private final PBRepository pbRepository;
  private final ClientRepository clientRepository;

  public List<PBClientDto> getAllClients(Long pbId) {

    List<Client> clients = getClientsByPBId(pbId);

    List<PBClientDto> pbClientDtoList = clients.stream()
            .map(client -> PBClientDto.builder()
                    .id(client.getId())
                    .name(client.getName())
                    .phone(client.getPhone())
                    .email(client.getEmail())
                    .currentAsset(client.getCurrentTotalAssets())
                    .currentProfitRate(calculateProfitRate(client.getInitAsset(), client.getCurrentTotalAssets()))
                    .targetProfitRate(client.getTargetProfitRate())
                    .build())
            .collect(Collectors.toList());

    return pbClientDtoList;
  }

  public double calculateProfitRate(double initialTotalAsset, double currentTotalAsset) {
    if (initialTotalAsset == 0) {   // 추후 수정
      return 0;
    }

    return ((currentTotalAsset - initialTotalAsset) / initialTotalAsset) * 100;
  }

  public List<Client> getClientsByPBId(Long pbId) {
    PB pb = findPBById(pbId);
    return clientRepository.findByPb(pb);
  }

  public PB findPBById(Long userId){
    return pbRepository.findById(userId).orElseThrow(NoSuchElementException::new);
  }
}
