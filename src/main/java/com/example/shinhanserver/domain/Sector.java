package com.example.shinhanserver.domain;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sector")
public class Sector {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sector_id")
  private Long id;

  @OneToOne(mappedBy = "sector")
  private Product product;

}