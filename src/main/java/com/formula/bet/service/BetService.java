package com.formula.bet.service;

import com.formula.bet.model.Bet;
import com.formula.bet.model.Driver;
import com.formula.bet.model.EventSession;
import com.formula.bet.model.User;
import com.formula.bet.respository.BetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BetService {

    private final BetRepository betRepository;

    public Bet save(User user, Driver driver, EventSession eventSession, BigDecimal amount) {
        Bet bet = new Bet();
        bet.setUser(user);
        bet.setDriver(driver);
        bet.setEventSession(eventSession);
        bet.setAmount(amount);
        bet.setStatus("PENDING");
        return this.betRepository.save(bet);
    }

    public void update(Long id, String status) {
        Bet bet = this.betRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bet not found with id: " + id));
        bet.setStatus(status);
        this.betRepository.save(bet);
    }

    public List<Bet> findByEventSessionSessionKeyAndStatus(Integer sessionKey) {
        return this.betRepository.findByEventSessionSessionKeyAndStatus(sessionKey,"PENDING");
    }

}
