package com.example.shinhanserver.domain.form;

import com.example.shinhanserver.domain.entity.Career;
import com.example.shinhanserver.domain.entity.PB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareerRepository extends JpaRepository<Career, Long> {
    List<Career> findAllByPb(PB pb);

    List<Career> findByPb(PB pb);
}
