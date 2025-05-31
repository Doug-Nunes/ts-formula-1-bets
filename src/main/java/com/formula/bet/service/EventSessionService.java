package com.formula.bet.service;

import com.formula.bet.dto.openf1.SessionResponseDTO;
import com.formula.bet.model.EventSession;
import com.formula.bet.respository.EventSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventSessionService {

    private final EventSessionRepository eventSessionRepository;

    public EventSession save(SessionResponseDTO sessionResponseDTO) {
        var sessionExisted = findBySessionKey(sessionResponseDTO.getSessionKey());
        if (sessionExisted != null) {
            return sessionExisted;
        }

        EventSession session = new EventSession();
        session.setSessionKey(sessionResponseDTO.getSessionKey());
        session.setSessionType(sessionResponseDTO.getSessionType());
        session.setCountry(sessionResponseDTO.getCountryName());
        session.setYear(sessionResponseDTO.getYear());
        return this.eventSessionRepository.save(session);
    }

    public EventSession findBySessionKey(Integer sessionKey) {
        return this.eventSessionRepository.findBySessionKey(sessionKey);
    }
}
