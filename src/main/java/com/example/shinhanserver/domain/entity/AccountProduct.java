package com.example.shinhanserver.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "accountProduct")
public class AccountProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "accountProduct_id")
  private Long id;

  private int amount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "account_id")
  private Account account;

  @OneToOne
  @JoinColumn(name = "product_id")
  private Product product;
}
