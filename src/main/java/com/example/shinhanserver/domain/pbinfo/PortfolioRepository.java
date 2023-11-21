package com.example.shinhanserver.domain.pbinfo;

import com.example.shinhanserver.domain.entity.PB;
import com.example.shinhanserver.domain.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findAllByPb(PB pb);
    Optional<Portfolio> findById(Long id);
}
