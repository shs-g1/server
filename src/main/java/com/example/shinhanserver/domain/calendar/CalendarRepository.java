package com.example.shinhanserver.domain.calendar;

import com.example.shinhanserver.domain.PB.PB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
  List<Calendar> findByPb(PB pb);
}
