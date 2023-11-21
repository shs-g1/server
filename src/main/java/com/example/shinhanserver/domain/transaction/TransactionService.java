package com.example.shinhanserver.domain.transaction;

import com.example.shinhanserver.domain.client.ClientService;
import com.example.shinhanserver.domain.entity.Client;
import com.example.shinhanserver.domain.entity.Product;
import com.example.shinhanserver.domain.entity.Transaction;
import com.example.shinhanserver.domain.pbinfo.ProductRepository;
import com.example.shinhanserver.domain.product.ProductService;
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
  private final ProductService productService;

  public List<TransactionCategoryDto> getTransaction(Long clientId) {
    Client client = clientService.findClientById(clientId);

    List<Transaction> allTransactions = client.getAccountList().stream()
            .flatMap(account -> account.getTransactionList().stream())
            .collect(Collectors.toList());


    Map<String, List<Transaction>> categoryTransactionMap = allTransactions.stream()
            .filter(transaction -> productService.findProductById(transaction.getProductId()) != null)
            .collect(Collectors.groupingBy(
                    transaction -> productService.findProductById(transaction.getProductId()).getCategory()
            ));

    List<TransactionCategoryDto> transactionCategories = categoryTransactionMap.entrySet().stream()
            .map(entry -> {
              String category = entry.getKey();
              List<Transaction> transactions = entry.getValue();

              List<TransactionDto> transactionDtoList = transactions.stream()
                      .map(transaction -> {
                        Product product = productService.findProductById(transaction.getProductId());
                        if (product != null) {
                          return TransactionDto.builder()
                                  .code(product.getCode())
                                  .name(product.getProductName())
                                  .amount(transaction.getAmount())
                                  .price(transaction.getPrice())
                                  .build();
                        } else {
                          return TransactionDto.builder()
                                  .code("N/A")
                                  .name("N/A")
                                  .amount(transaction.getAmount())
                                  .price(transaction.getPrice())
                                  .build();
                        }
                      })
                      .collect(Collectors.toList());

              return new TransactionCategoryDto(category, transactionDtoList);
            })
            .collect(Collectors.toList());

    return transactionCategories;
  }

}
