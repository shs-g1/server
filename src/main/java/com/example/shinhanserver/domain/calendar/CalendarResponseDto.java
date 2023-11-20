package com.example.shinhanserver.domain.calendar;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class CalendarResponseDto {

  private long id;
  private LocalDate date;
  private LocalTime time;
  private String title;

  public CalendarResponseDto(Calendar calendar) {
    this.id = calendar.getId();
    this.date = calendar.getDate();
    this.time = calendar.getTime();
    this.title = calendar.getTitle();
  }
}
