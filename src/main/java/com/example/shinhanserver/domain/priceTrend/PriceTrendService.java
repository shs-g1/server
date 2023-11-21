package com.example.shinhanserver.domain.priceTrend;

import com.example.shinhanserver.domain.account.AccountRepository;
import com.example.shinhanserver.domain.client.ClientService;
import com.example.shinhanserver.domain.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PriceTrendService {

  private final AccountRepository accountRepository;
  private final PriceTrendRepository priceTrendRepository;
  private final ClientService clientService;

  public List<PriceTrendDto> getProfitRate(Long clientId) {
    Client client = clientService.findClientById(clientId);
    List<Account> accounts = accountRepository.findByClient(client);

    List<PriceTrendDto> result = new ArrayList<>();

    for (Account account : accounts) {
      List<Integer> labels = priceTrendRepository.findDistinctMonthsByClientId(clientId);
      List<Double> profitRates = new ArrayList<>();

      for (int i = 1; i < labels.size(); i++) {
        int currentMonth = labels.get(i);
        int prevMonth = labels.get(i - 1);

        double totalAssetsPrevMonth = getTotalAssets(account, prevMonth);
        double totalAssetsCurrentMonth = getTotalAssets(account, currentMonth);

        double profitRate = calculateProfitRate(totalAssetsPrevMonth, totalAssetsCurrentMonth);
        profitRates.add(profitRate);
      }

      List<Integer> labelSubList = labels.subList(1, labels.size());
      PriceTrendDto priceTrendDto = new PriceTrendDto(labelSubList, profitRates);
      result.add(priceTrendDto);
    }

    return result;
  }

  private double getTotalAssets(Account account, int month) {
    return account.getAccountProductList().stream()
            .mapToDouble(accountProduct -> {
              Product product = accountProduct.getProduct();
              return calculatePriceForMonth(product, month, accountProduct.getAmount());
            })
            .sum();
  }

  private double calculateProfitRate(double totalAssetsPrevMonth, double totalAssetsCurrentMonth) {
    return totalAssetsPrevMonth != 0.0
            ? (totalAssetsCurrentMonth - totalAssetsPrevMonth) / totalAssetsPrevMonth * 100.0
            : 0.0;
  }

  public double calculatePriceForMonth(Product product, int month, int amount) {
    List<PriceTrend> priceTrends = priceTrendRepository.findByProductAndMonth(product, month);

    if (!priceTrends.isEmpty()) {
      double totalPrice = priceTrends.stream().mapToDouble(PriceTrend::getPrice).sum();
      return totalPrice * amount;
    } else {
      return 0.0;
    }
  }

}
