package com.example.shinhanserver.domain.PB;

import java.util.*;
import javax.persistence.*;

import com.example.shinhanserver.domain.calendar.Calendar;
import com.example.shinhanserver.domain.Career;
import com.example.shinhanserver.domain.Certification;
import com.example.shinhanserver.domain.Education;
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

  private String specialization;

  private String introduction;

  private Integer cumulativeClientCount;

  private double cumulativeTotalAmount;

  private double cumulativeReturn;

  private double profit;

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Calendar> CalendarList = new ArrayList<>();

  private String loginId;

  private String loginPw;

  private String image;

  @OneToOne
  @JoinColumn(name = "calendar_id")
  private Calendar calendar;

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Education> EducationList = new ArrayList<>();

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Career> carrerList = new ArrayList<>();

  @OneToMany(mappedBy = "pb", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Certification> certificationList = new ArrayList<>();
}