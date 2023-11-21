package com.example.shinhanserver.domain.priceTrend;

import com.example.shinhanserver.domain.entity.Client;
import com.example.shinhanserver.domain.entity.PriceTrend;
import com.example.shinhanserver.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceTrendRepository extends JpaRepository<PriceTrend, Long> {
  @Query("SELECT DISTINCT pt.month FROM PriceTrend pt JOIN pt.product p JOIN p.account a JOIN a.client c WHERE c.id = :clientId")
  List<Integer> findDistinctMonthsByClientId(@Param("clientId") Long clientId);


  List<PriceTrend> findByProductAndMonth(Product product, int month);
}
