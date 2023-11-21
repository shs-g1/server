package com.example.shinhanserver.domain.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "Portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private Long id;

    private String name;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pb_id")
//    private PB pb;

    @OneToMany(mappedBy = "portfolio")
    private List<Transaction> transaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pb_id")
    private PB pb;
}
