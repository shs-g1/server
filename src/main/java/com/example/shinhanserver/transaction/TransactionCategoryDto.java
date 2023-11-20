package com.example.shinhanserver.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionCategoryDto {
  private String category;
  private List<TransactionDto> transactionDtoList;
}
