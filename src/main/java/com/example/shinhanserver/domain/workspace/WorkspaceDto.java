package com.example.shinhanserver.domain.workspace;

import com.example.shinhanserver.domain.PB.PBClientDto;
import com.example.shinhanserver.domain.calendar.CalendarResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkspaceDto {

  private List<CalendarResponseDto> calendarResponseDto;
  private List<PBClientDto> clientResponseDto;
  private double incentive;

}
