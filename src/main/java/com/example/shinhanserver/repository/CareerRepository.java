package com.example.shinhanserver.repository;

import com.example.shinhanserver.domain.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {
}
