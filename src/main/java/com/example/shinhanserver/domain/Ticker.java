package com.example.shinhanserver.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ticker")
public class Ticker {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ticker_id")
  private Long id;

  @OneToOne(mappedBy = "ticker")
  private Product product;

  private String name;


}