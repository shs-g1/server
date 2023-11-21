package com.example.shinhanserver.transaction;

import com.example.shinhanserver.domain.client.ClientService;
import com.example.shinhanserver.domain.entity.Client;
import com.example.shinhanserver.domain.entity.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TransactionService {

  private final ClientService clientService;

  public List<TransactionCategoryDto> getTransaction(Long clientId){
    Client client = clientService.findClientById(clientId);

    List<Transaction> allTransactions = client.getAccountList().stream()
            .flatMap(account -> account.getTransactionList().stream())
            .collect(Collectors.toList());

    Map<String, List<Transaction>> categoryTransactionMap = allTransactions.stream()
            .collect(Collectors.groupingBy(
                    transaction -> transaction.getProduct().getCategory()
            ));

    List<TransactionCategoryDto> transactionCategories = categoryTransactionMap.entrySet().stream()
            .map(entry -> {
              String category = entry.getKey();
              List<Transaction> transactions = entry.getValue();

              List<TransactionDto> transactionDtoList = transactions.stream()
                      .map(transaction -> TransactionDto.builder()
                              .code(transaction.getProduct().getCode())
                              .name(transaction.getProduct().getProductName())
                              .amount(transaction.getAmount())
                              .price(transaction.getPrice())
                              .build())
                      .collect(Collectors.toList());

              return new TransactionCategoryDto(category, transactionDtoList);
            })
            .collect(Collectors.toList());

    return transactionCategories;

  }


}
