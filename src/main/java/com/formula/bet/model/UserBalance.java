package com.formula.bet.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_balance", schema = "bets")
public class UserBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_type")
    private String currencyType;

    @Column
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public UserBalance(String currencyType, BigDecimal amount, User user) {
        this.currencyType = currencyType;
        this.amount = amount;
        this.user = user;
    }

}
