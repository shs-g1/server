package com.example.shinhanserver.domain.entity;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.*;


import java.time.LocalDate;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "certification")
public class Certification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "certification_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pb_id")
  private PB pb;

  private String name;

  private String publisher;

  private LocalDate date;
}