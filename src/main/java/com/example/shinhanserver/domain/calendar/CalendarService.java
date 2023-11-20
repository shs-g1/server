package com.example.shinhanserver.domain.calendar;

import com.example.shinhanserver.domain.entity.PB;
import com.example.shinhanserver.domain.PB.PBService;
import com.example.shinhanserver.domain.entity.Calendar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CalendarService {

  private final CalendarRepository calendarRepository;
  private final PBService pbService;

  @Transactional
  public CalendarResponseDto addSchedule(CalendarRequestDto request, Long pbId) {

    PB pb = pbService.findPBById(pbId);

    Calendar calendar = Calendar.builder()
            .pb(pb)
            .date(request.getDate())
            .time(request.getTime())
            .title(request.getTitle())
            .build();

    return new CalendarResponseDto(calendarRepository.save(calendar));
  }

  public List<CalendarResponseDto> getCalendar(Long pbId){
    PB pb = pbService.findPBById(pbId);
    return calendarRepository.findByPb(pb).stream()
            .map(CalendarResponseDto::new)
            .collect(Collectors.toList());
  }

}
