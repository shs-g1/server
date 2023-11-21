package com.example.shinhanserver.domain.portfolio;


import com.example.shinhanserver.domain.account.AccountRepository;
import com.example.shinhanserver.domain.client.ClientService;
import com.example.shinhanserver.domain.entity.Account;
import com.example.shinhanserver.domain.entity.AccountProduct;
import com.example.shinhanserver.domain.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PortfolioService {

  private final ClientService clientService;
  private final AccountRepository accountRepository;

  public List<SectorPercentDto> getPortfolio(Long clientId){

    Map<String, Double> categoryAmounts = getCategoryAmounts(clientId);

    double totalAmount = categoryAmounts.values().stream()
            .mapToDouble(Double::doubleValue)
            .sum();

    List<SectorPercentDto> portfolio = categoryAmounts.entrySet().stream()
            .map(entry -> {
              double percent = (entry.getValue() / totalAmount) * 100.0;
              return SectorPercentDto.builder()
                      .sector(entry.getKey())
                      .percent(percent)
                      .build();
            })
            .collect(Collectors.toList());

    return portfolio;
  }

  public Map<String, Double> getCategoryAmounts(Long clientId) {
    Client client = clientService.findClientById(clientId);

    List<Account> accounts = accountRepository.findByClient(client);

    List<AccountProduct> accountProductList = accounts.stream()
            .flatMap(account -> account.getAccountProductList().stream())
            .collect(Collectors.toList());

    Map<Long, String> productCategoryMap = accountProductList.stream()
            .collect(Collectors.toMap(
                    accountProduct -> accountProduct.getProduct().getId(),
                    accountProduct -> accountProduct.getProduct().getCategory()
            ));

    Map<String, Double> categoryAmounts = accountProductList.stream()
            .collect(Collectors.groupingBy(
                    accountProduct -> productCategoryMap.get(accountProduct.getProduct().getId()),
                    Collectors.summingDouble(accountProduct -> accountProduct.getAmount() * accountProduct.getProduct().getPrice())
            ));

    return categoryAmounts;
  }


}
