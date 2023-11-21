package com.example.shinhanserver.domain.clientinfo;

import com.example.shinhanserver.domain.client.ClientService;
import com.example.shinhanserver.domain.portfolio.PortfolioService;
import com.example.shinhanserver.domain.priceTrend.PriceTrendService;
import com.example.shinhanserver.domain.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientInfoService {
  private final ClientService clientService;
  private final PortfolioService portfolioService;
  private final TransactionService transactionService;
  private final PriceTrendService priceTrendService;

  @Transactional
  public ClientInfoDto getClientInformation(Long clientId) {

    return ClientInfoDto.builder()
            .clientDto(clientService.getClientInfo(clientId))
            .portfolioDto(portfolioService.getPortfolio(clientId))
            .profitRateDto(priceTrendService.getProfitRate(clientId))
            .accountDtoList(clientService.getAccountList(clientId))
            .transactionCategoryDtoList(transactionService.getTransaction(clientId))
            .build();
  }
}
