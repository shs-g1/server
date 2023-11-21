package com.example.shinhanserver.domain.clientinfo;

import com.example.shinhanserver.domain.PB.PBClientDto;
import com.example.shinhanserver.domain.account.AccountDto;
import com.example.shinhanserver.domain.calendar.CalendarResponseDto;
import com.example.shinhanserver.domain.client.ClientDto;
import com.example.shinhanserver.domain.entity.Transaction;
import com.example.shinhanserver.domain.portfolio.SectorPercentDto;
import com.example.shinhanserver.transaction.TransactionCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientInfoDto {
  private ClientDto clientDto;
  private List<SectorPercentDto> portfolioDto;
  private List<AccountDto> accountDtoList;
  private List<TransactionCategoryDto> transactionCategoryDtoList;
}
