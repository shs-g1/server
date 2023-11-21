package com.example.shinhanserver.domain.form;

import com.example.shinhanserver.domain.entity.Education;
import com.example.shinhanserver.domain.entity.PB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findAllByPb(PB pb);

    List<Education> findByPb(PB pb);
}
