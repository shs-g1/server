package com.example.shinhanserver.domain.workspace;

import com.example.shinhanserver.domain.calendar.CalendarRequestDto;
import com.example.shinhanserver.domain.calendar.CalendarResponseDto;
import com.example.shinhanserver.domain.calendar.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/workspace")
@Controller
public class WorkspaceController {

  private final CalendarService calendarService;

  @PostMapping("/calendar")
  public ResponseEntity<CalendarResponseDto> createReport(@RequestBody CalendarRequestDto calendarDto) {
    return ResponseEntity.status(HttpStatus.OK).body(calendarService.addSchedule(calendarDto));
  }

}