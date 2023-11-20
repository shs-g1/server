package com.example.shinhanserver.domain.workspace;

import com.example.shinhanserver.domain.PB.PBService;
import com.example.shinhanserver.domain.calendar.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkspaceService {
  private final CalendarService calendarService;
  private final PBService pbService;

  @Transactional
  public WorkspaceDto getWorkspaceInfo(Long pbId) {

    return WorkspaceDto.builder()
            .calendarResponseDto(calendarService.getCalendar(pbId))
            .clientResponseDto(pbService.getAllClients(pbId))
            .incentive(pbService.calculateIncentive(pbId))
            .build();
  }

}
