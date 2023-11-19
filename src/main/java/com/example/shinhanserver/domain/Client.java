package com.example.shinhanserver.domain;

import javax.persistence.*;

import com.example.shinhanserver.domain.PB.PB;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "client")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "client_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pb_id")
  private PB pb;

  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Account> AccountList = new ArrayList<>();

  private String name;

  private String phone;

  private String email;

  private String type;

  private BigDecimal currentAsset;

  private BigDecimal initAsset;

}