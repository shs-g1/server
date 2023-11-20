package com.example.shinhanserver.repository;

import com.example.shinhanserver.domain.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
