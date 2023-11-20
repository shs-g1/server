package com.example.shinhanserver.domain.workspace;

import com.example.shinhanserver.domain.calendar.CalendarRequestDto;
import com.example.shinhanserver.domain.calendar.CalendarResponseDto;
import com.example.shinhanserver.domain.calendar.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/workspace")
@Controller
public class WorkspaceController {

  private final CalendarService calendarService;
  private final WorkspaceService workspaceService;

  @PostMapping("/calendar")
  public ResponseEntity<CalendarResponseDto> createCalendar(@RequestBody CalendarRequestDto calendarDto, @RequestParam Long pbId) {
    return ResponseEntity.status(HttpStatus.OK).body(calendarService.addSchedule(calendarDto, pbId));
  }

  @GetMapping
  public ResponseEntity<WorkspaceDto> getWorkSpace(@RequestParam Long pbId) {
    return ResponseEntity.status(HttpStatus.OK).body(workspaceService.getWorkspaceInfo(pbId));
  }

}