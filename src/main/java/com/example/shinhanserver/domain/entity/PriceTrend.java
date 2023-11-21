package com.example.shinhanserver.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "priceTrend")
public class PriceTrend {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "priceTrend_id")
  private Long id;

  private Integer month;

  private double price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

}
