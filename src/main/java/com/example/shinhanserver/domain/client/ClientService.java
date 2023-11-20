package com.example.shinhanserver.domain.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientService {

  private final ClientRepository clientRepository;

  public ClientDto getClientInfo(Long clientId) {

    Client client = findClientById(clientId);

    return ClientDto.builder()
            .id(client.getId())
            .name(client.getName())
            .phone(client.getPhone())
            .email(client.getEmail())
            .type(client.getType())
            .currentProfitRate(calculateProfitRate(client.getInitAsset(), client.getCurrentTotalAssets()))
            .profits(calculateProfits(client))
            .totalAssets(client.getCurrentTotalAssets())
            .build();
  }
  public double calculateProfits(Client client) {
    double totalAssets = client.getCurrentTotalAssets();
    double initialAssets = client.getInitAsset();
    return totalAssets - initialAssets;
  }

  public double calculateProfitRate(double initialTotalAsset, double currentTotalAsset) {
    if (initialTotalAsset == 0) {
      return 0;
    }

    return ((currentTotalAsset - initialTotalAsset) / initialTotalAsset) * 100;
  }

  public Client findClientById(Long userId){
    return clientRepository.findById(userId).orElseThrow(NoSuchElementException::new);
  }
}
