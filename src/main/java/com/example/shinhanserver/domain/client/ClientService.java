package com.example.shinhanserver.domain.client;

import com.example.shinhanserver.domain.account.AccountDto;
import com.example.shinhanserver.domain.account.AccountRepository;
import com.example.shinhanserver.domain.entity.Account;
import com.example.shinhanserver.domain.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientService {

  private final ClientRepository clientRepository;
  private final AccountRepository accountRepository;

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

  public List<AccountDto> getAccountList(Long clientId) {
    Client client = findClientById(clientId);
    List<Account> accounts = accountRepository.findByClient(client);

    List<AccountDto> accountDtoList = accounts.stream()
            .map(account -> AccountDto.builder()
                    .accountNumberAndName(Arrays.asList(account.getAccountNumber(), client.getName()))
                    .totalAssets(account.getTotalAssets())
                    .withdrawalAmount(account.getWithdrawalAmount())
                    .build())
            .collect(Collectors.toList());

    return accountDtoList;

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
