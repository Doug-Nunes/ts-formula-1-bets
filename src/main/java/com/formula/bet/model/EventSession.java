package com.formula.bet.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "event_session", schema = "bets")
public class EventSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "year")
    private String year;

    @Column(name = "session_type")
    private String sessionType;

    @Column(name = "session_key")
    private Integer sessionKey;

    @OneToMany
    @JoinColumn(name = "event_session_id")
    private List<Driver> drivers;
}
