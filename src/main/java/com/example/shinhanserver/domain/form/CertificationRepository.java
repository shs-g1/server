package com.example.shinhanserver.domain.form;

import com.example.shinhanserver.domain.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CertificationRepository extends JpaRepository<Certification, Long> {

    //Optional<Certification> findByPb();

}
