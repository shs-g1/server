package com.example.shinhanserver.domain.entity;

import java.util.*;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.*;

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

  private String introduction;

  private Integer cumulativeClientCount;

  private double cumulativeTotalAmount;

  private double cumulativeReturn;

  private double profit;

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Calendar> CalendarList = new ArrayList<>();

  private String loginId;

  private String loginPw;

  @Column(columnDefinition = "LongText")
  private String image;

  @OneToOne
  @JoinColumn(name = "calendar_id")
  private Calendar calendar;

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Specialization> specializationList = new ArrayList<>();

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Education> EducationList = new ArrayList<>();

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Career> careerList = new ArrayList<>();

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Certification> certificationList = new ArrayList<>();

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Portfolio> portfolioList = new ArrayList<>();
}