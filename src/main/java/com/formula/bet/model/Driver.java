package com.formula.bet.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "driver", schema = "bets")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "id_number")
    private Integer idNumber;

    @Column(name = "odds")
    private Integer odds;

    @ManyToOne(fetch = FetchType.LAZY)
    private EventSession eventSession;

}
