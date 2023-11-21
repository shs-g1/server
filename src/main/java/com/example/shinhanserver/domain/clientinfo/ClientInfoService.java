package com.example.shinhanserver.domain.clientinfo;

import com.example.shinhanserver.domain.PB.PBService;
import com.example.shinhanserver.domain.account.AccountDto;
import com.example.shinhanserver.domain.calendar.CalendarService;
import com.example.shinhanserver.domain.client.ClientDto;
import com.example.shinhanserver.domain.client.ClientService;
import com.example.shinhanserver.domain.portfolio.PortfolioService;
import com.example.shinhanserver.domain.portfolio.SectorPercentDto;
import com.example.shinhanserver.domain.workspace.WorkspaceDto;
import com.example.shinhanserver.transaction.TransactionCategoryDto;
import com.example.shinhanserver.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientInfoService {
  private final ClientService clientService;
  private final PortfolioService portfolioService;
  private final TransactionService transactionService;

  @Transactional
  public ClientInfoDto getClientInformation(Long clientId) {

    return ClientInfoDto.builder()
            .clientDto(clientService.getClientInfo(clientId))
            .portfolioDto(portfolioService.getPortfolio(clientId))
//            .profitRateDto(priceTrendService.getProfitRate(clientId))
            .accountDtoList(clientService.getAccountList(clientId))
            .transactionCategoryDtoList(transactionService.getTransaction(clientId))
            .build();
  }
}
