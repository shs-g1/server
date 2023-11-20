package com.example.shinhanserver.domain.PB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PBRepository extends JpaRepository<PB, Long> {
  Optional<PB> findByLoginIdAndLoginPw(String loginId, String loginPw);
  Optional<PB> findByLoginId(String loginId);

}
