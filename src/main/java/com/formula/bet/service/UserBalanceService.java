package com.formula.bet.service;

import com.formula.bet.exception.NotFoundException;
import com.formula.bet.model.User;
import com.formula.bet.model.UserBalance;
import com.formula.bet.respository.UserBalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserBalanceService {

    private final UserBalanceRepository userBalanceRepository;

    public UserBalance save(User user){
        var userBalance = new UserBalance("EUR", BigDecimal.valueOf(100.00d), user);
        return this.userBalanceRepository.save(userBalance);
    }

    public void update(Long id, BigDecimal amount){
        var userBalance = this.userBalanceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User balance not found"));
        userBalance.setAmount(amount);
        this.userBalanceRepository.save(userBalance);
    }
}
