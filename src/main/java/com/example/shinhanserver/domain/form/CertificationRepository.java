package com.example.shinhanserver.domain.form;

import com.example.shinhanserver.domain.entity.Certification;
import com.example.shinhanserver.domain.entity.PB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
    List<Certification> findAllByPb(PB pb);
}
