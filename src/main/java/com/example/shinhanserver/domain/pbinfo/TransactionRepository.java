package com.example.shinhanserver.domain.pbinfo;

import com.example.shinhanserver.domain.entity.Portfolio;
import com.example.shinhanserver.domain.entity.Product;
import com.example.shinhanserver.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByPortfolioAndTransactionType(Portfolio portfolio, String transactionType);
    Optional<Transaction> findByPortfolioAndTransactionTypeAndProductId(Portfolio portfolio, String transactionType, Long productId);
}
