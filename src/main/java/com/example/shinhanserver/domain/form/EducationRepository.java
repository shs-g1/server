package com.example.shinhanserver.domain.form;

import com.example.shinhanserver.domain.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
