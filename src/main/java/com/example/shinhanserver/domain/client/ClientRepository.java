package com.example.shinhanserver.domain.client;

import com.example.shinhanserver.domain.PB.PB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  List<Client> findByPb(PB pb);
}
