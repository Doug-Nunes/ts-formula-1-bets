package com.formula.bet.service;

import com.formula.bet.model.EventOutcome;
import com.formula.bet.respository.EventOutcomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventOutcomeService {

    private final EventOutcomeRepository eventOutcomeRepository;

    public EventOutcome save(Integer driverId, Integer sessionKey) {
        var eventOutcome = new EventOutcome();
        eventOutcome.setDriverId(driverId);
        eventOutcome.setSessionKey(sessionKey);
        return this.eventOutcomeRepository.save(eventOutcome);
    }
}
