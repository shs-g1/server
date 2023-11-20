package com.example.shinhanserver.domain.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "Specialization")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    private Long id;

    private String field1;

    private String field2;

    private String field3;

    @OneToOne(mappedBy = "specialization")
    private PB pb;
}
