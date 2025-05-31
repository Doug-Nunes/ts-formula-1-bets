package com.formula.bet.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "bet", schema = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @Column(name = "amount")
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.LAZY)
    private EventSession eventSession;

    @Column(name = "status")
    private String status;

    @Column(name = "bet_date")
    private LocalDateTime betDate;

    @PrePersist
    void prePersist() {
        this.betDate = LocalDateTime.now();
    }

}
