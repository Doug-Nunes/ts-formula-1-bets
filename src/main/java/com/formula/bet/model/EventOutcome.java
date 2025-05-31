package com.formula.bet.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "event_outcome", schema = "bets")
public class EventOutcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "session_key")
    private Integer sessionKey;

}
