package com.formula.bet.service;

import com.formula.bet.model.User;
import com.formula.bet.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserBalanceService userBalanceService;

    public User findByName(String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            return this.save(name);
        }
        return user;
    }

    public User save(String name) {
        User user = userRepository.save(new User(name));
        user.setUserBalance(userBalanceService.save(user));
        return user;
    }
}
