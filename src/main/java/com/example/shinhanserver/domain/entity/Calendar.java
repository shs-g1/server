package com.example.shinhanserver.domain.entity;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "calendar")
public class Calendar {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "calendar_id")
  private Long id;

  private LocalDate date;

  private LocalTime time;

  private String title;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pb_id")
  private PB pb;

  @Builder
  public Calendar(PB pb, LocalDate date, LocalTime time, String title){
    this.pb = pb;
    this.date = date;
    this.time = time;
    this.title = title;
  }

}