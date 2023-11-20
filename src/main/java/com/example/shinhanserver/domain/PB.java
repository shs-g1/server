package com.example.shinhanserver.domain;

import java.util.*;
import javax.persistence.*;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "pb")
public class PB {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pb_id")
  private Long id;

  private String name;

  private String phone;

  private String email;

  private String profile;

  private String field1;

  private String field2;

  private String field3;

  private String introduction;

  private int cumulativeClientCount;

  private String cumulativeTotalAmount;

  private BigDecimal cumulativeReturn;

  private BigDecimal profit;

  private String loginId;

  private String loginPw;

  private String image;

  @OneToOne
  @JoinColumn(name = "calendar_id")
  private Calendar calendar;

  @OneToOne
  @JoinColumn(name = "specialization_id")
  private Specialization specialization;

//  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
//  private List<Portfolio> portfolioList = new ArrayList<>();

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Education> EducationList = new ArrayList<>();

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Career> carrerList = new ArrayList<>();

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Certification> certificationList = new ArrayList<>();
}