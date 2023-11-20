package com.example.shinhanserver.domain.entity;

import javax.persistence.*;

import com.example.shinhanserver.domain.entity.PB;
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
@Table(name = "education")
public class Education {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "education_id")
  private Long id;

  private String edu;

  private String major;

  private LocalDate start_date;

  private LocalDate end_date;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pb_id")
  private PB pb;
}