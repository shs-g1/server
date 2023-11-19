package com.example.shinhanserver.domain.PB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PBRepository extends JpaRepository<PB, Long> {

}
