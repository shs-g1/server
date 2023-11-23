package com.example.shinhanserver.domain.pbinfo.service;

import com.example.shinhanserver.domain.entity.PB;
import com.example.shinhanserver.domain.entity.Portfolio;
import com.example.shinhanserver.domain.entity.Product;
import com.example.shinhanserver.domain.entity.Transaction;
import com.example.shinhanserver.domain.pbinfo.PortfolioRepository;
import com.example.shinhanserver.domain.pbinfo.ProductRepository;
import com.example.shinhanserver.domain.pbinfo.TransactionRepository;
import com.example.shinhanserver.domain.pbinfo.service.dto.PortfolioDetailDto;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PortfolioDetailService {

    private final PortfolioRepository portfolioRepository;
    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;

    public PortfolioDetailDto getPortfolioDetail(Long portfolioId) {

        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException("Portfolio not found with ID: " + portfolioId));

        List<Transaction> buyTxList = transactionRepository.findAllByPortfolioAndTransactionType(portfolio, "매수");
        //List<Transaction> sellTxList = transactionRepository.findAllByPortfolioAndTransactionType(portfolio, "매도");

        List<String> labels = new ArrayList<>();
        List<String> productNames = new ArrayList<>();
        List<Long> realizedGainLoss = new ArrayList<>();
        List<Long> evaluatePrice = new ArrayList<>();
        List<Double> accumRoRs = new ArrayList<>();
        List<String> durations = new ArrayList<>();
        List<Double> ratios = new ArrayList<>();

        long totalPrice = 0;
        for(Transaction buyTx: buyTxList) {
            Product product = productRepository.findById(buyTx.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + buyTx.getProductId()));
            labels.add(product.getCategory());
            productNames.add(product.getProductName());

            Transaction sellTx = transactionRepository.findByPortfolioAndTransactionTypeAndProductId(portfolio, "매도", buyTx.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Transaction not found with Portfolio, TrType, Product"));

            LocalDate startDate = buyTx.getTransactionDate();
            LocalDate endDate = sellTx.getTransactionDate();
            Period period = Period.between(startDate, endDate);
            int years = period.getYears();
            int months = period.getMonths();

            realizedGainLoss.add((long) sellTx.getPrice() - buyTx.getPrice());
            evaluatePrice.add((long) sellTx.getPrice());
            accumRoRs.add(((sellTx.getPrice()-buyTx.getPrice())/(double) buyTx.getPrice() * 100.0));
            durations.add(years + "년 "+ months + "개월");
            totalPrice += buyTx.getPrice();
        }

        for(Transaction buyTx: buyTxList) {
//            System.out.println("total Price: " + totalPrice);
//            System.out.println("Ratio: " + Math.round((buyTx.getPrice() / (double)totalPrice) * 1000.0) / 10.0);
//            System.out.println("buyTx Price: " + buyTx.getPrice());
//            System.out.println("buyTx/total Price: " + (buyTx.getPrice() / totalPrice));

            ratios.add(Math.round((buyTx.getPrice() / (double)totalPrice) * 1000.0) / 10.0);
        }

        double tmp_total = 0.0;
        for(double ratio: ratios) {
            tmp_total += ratio;
        }

        if (tmp_total != 100) {
            int index = 0;
            double diff = 100 - tmp_total;

            // 가장 차이가 큰 값을 찾아서 조정
            double maxDiff = 0;
            for (int i = 0; i < ratios.size(); i++) {
                double diffAbs = Math.abs(ratios.get(i) - Math.floor(ratios.get(i)));
                if (diffAbs > maxDiff) {
                    maxDiff = diffAbs;
                    index = i;
                }
            }
            double newValue = ratios.get(index) + diff;
            ratios.set(index, newValue);
        }

        return PortfolioDetailDto.builder()
                .labels(labels)
                .productNames(productNames)
                .realizedGainLoss(realizedGainLoss)
                .evaluatePrice(evaluatePrice)
                .accumRoRs(accumRoRs)
                .durations(durations)
                .ratios(ratios)
                .build();
    }
}
