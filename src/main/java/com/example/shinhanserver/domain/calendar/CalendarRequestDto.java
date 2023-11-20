package com.example.shinhanserver.domain.calendar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CalendarRequestDto {

  private LocalDate date;
  private LocalTime time;
  private String schedule;

}
