package com.example.shinhanserver.domain.pbinfo;

import com.example.shinhanserver.domain.entity.PB;
import com.example.shinhanserver.domain.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    List<Specialization> findAllByPb(PB pb);

    List<Specialization> findByPb(PB pb);
}
