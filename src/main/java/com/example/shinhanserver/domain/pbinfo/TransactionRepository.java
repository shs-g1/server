package com.example.shinhanserver.domain.pbinfo;

import com.example.shinhanserver.domain.entity.Portfolio;
import com.example.shinhanserver.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByPortfolioAndTransactionType(Portfolio portfolio, String transactionType);

}
