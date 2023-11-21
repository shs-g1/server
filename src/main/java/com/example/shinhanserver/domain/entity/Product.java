package com.example.shinhanserver.domain.entity;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long id;

  private String category;

  private String productName;

  private double price;

  private String code;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "account_id")
  private Account account;

  @OneToOne(mappedBy = "product")
  private AccountProduct accountProduct;

  @OneToOne
  @JoinColumn(name = "priceTrend_id")
  private PriceTrend priceTrend;

}