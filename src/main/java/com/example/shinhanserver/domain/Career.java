package com.example.shinhanserver.domain;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "career")
public class Career {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "career_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pb_id")
  private PB pb;

  private String organization;

  private String location;

  private LocalDate start_date;

  private LocalDate end_date;

}
