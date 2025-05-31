package com.formula.bet.service;

import com.formula.bet.builder.EventBuilder;
import com.formula.bet.client.OpenF1Client;
import com.formula.bet.dto.BetRequestDTO;
import com.formula.bet.dto.BetResponseDTO;
import com.formula.bet.dto.EventDTO;
import com.formula.bet.dto.openf1.DriverResponseDTO;
import com.formula.bet.dto.openf1.SessionResponseDTO;
import com.formula.bet.exception.InsufficientBalanceException;
import com.formula.bet.exception.NotFoundException;
import com.formula.bet.model.Bet;
import com.formula.bet.model.Driver;
import com.formula.bet.model.EventSession;
import com.formula.bet.model.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FormulaService {

    private final OpenF1Client f1Client;
    private final DriverService driverService;
    private final UserService userService;
    private final UserBalanceService userBalanceService;
    private final BetService betService;
    private final EventSessionService eventSessionService;
    private final EventOutcomeService eventOutcomeService;

    public List<EventDTO> getEventsAndDriverMarket(String sessionType, Integer year, String country) {
        log.info("Fetching events for sessionType: {}, year: {}, country: {}", sessionType, year, country);
        List<SessionResponseDTO> sessions = this.f1Client.getSessionByCountryAndNameAndYear(country, sessionType, year);
        return sessions.stream().map(this::getEventDTO).toList();
    }

    @SneakyThrows
    private EventDTO getEventDTO(SessionResponseDTO session) {
        return EventBuilder.build(session, getDriversBySessionKey(session.getSessionKey()));
    }

    public BetResponseDTO generateBet(BetRequestDTO requestDTO) {
        log.info("Generating bet for user: {}, driverId: {}, sessionKey: {}, amount: {}",
                requestDTO.getUserName(), requestDTO.getDriverId(), requestDTO.getSessionKey(), requestDTO.getAmount());
        User user = userService.findByName(requestDTO.getUserName());
        validateBalance(requestDTO, user);
        SessionResponseDTO sessionResponseDTO = getSessionResponseBySessionKey(requestDTO);
        DriverResponseDTO driverResponseDTO = getDriverResponseByDriverNumberAndSessionKey(requestDTO);

        EventSession eventSession = this.eventSessionService.save(sessionResponseDTO);
        Driver driver = driverService.save(driverResponseDTO, eventSession);
        Bet bet = this.betService.save(user, driver, eventSession, requestDTO.getAmount());
        BigDecimal betBalance = user.getUserBalance().getAmount().subtract(requestDTO.getAmount());
        userBalanceService.update(user.getId(), betBalance);

        return BetResponseDTO.builder()
                .status(bet.getStatus())
                .amount(bet.getAmount())
                .driver(driver.getFullName())
                .user(user.getName())
                .build();
    }

    private List<DriverResponseDTO> getDriversBySessionKey(Integer sessionKey) {
        return this.f1Client.getDriversBySessionKey(sessionKey);
    }

    private DriverResponseDTO getDriverResponseByDriverNumberAndSessionKey(BetRequestDTO requestDTO) {
        return this.f1Client.getDriversByDriverNumberAndSessionKey(
                        requestDTO.getDriverId(),
                        requestDTO.getSessionKey())
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Driver not available to bet on"));
    }

    private SessionResponseDTO getSessionResponseBySessionKey(BetRequestDTO requestDTO) {
        return this.f1Client.getSessionBySessionKey(requestDTO.getSessionKey())
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Session not available to bet on"));
    }

    private static void validateBalance(BetRequestDTO requestDTO, User user) {
        if(user.getUserBalance().getAmount().compareTo(requestDTO.getAmount()) < 0) {
            throw new InsufficientBalanceException("Insufficient balance to place bet");
        }
    }

    public void eventOutCome(Integer sessionKey, Integer driverId) {
        log.info("Processing event outcome for sessionKey: {}, driverId: {}", sessionKey, driverId);
        List<Bet> bets = this.betService.findByEventSessionSessionKeyAndStatus(sessionKey);
        validateBet(sessionKey, bets);
        this.eventOutcomeService.save(driverId, sessionKey);
        var wonList = bets.stream()
                .filter(bet -> bet.getDriver().getIdNumber().equals(driverId))
                .toList();
        var lostList = bets.stream()
                .filter(bet -> !bet.getDriver().getIdNumber().equals(driverId))
                .toList();
        handleLostBets(lostList);
        handleWonBets(wonList);
    }

    private static void validateBet(Integer sessionKey, List<Bet> bets) {
        if(bets.isEmpty()) {
            log.warn("No bets found for sessionKey: {}", sessionKey);
            throw new NotFoundException("No bets found for the provided session key");
        }
    }

    private void handleWonBets(List<Bet> wonList) {
        wonList.forEach(bet -> {
            this.betService.update(bet.getId(), "WON");
            BigDecimal wonPrize = bet.getAmount().multiply(BigDecimal.valueOf(2));
            BigDecimal newBalance = bet.getUser().getUserBalance().getAmount().add(wonPrize);
            this.userBalanceService.update(bet.getUser().getId(), newBalance);
        });
    }

    private void handleLostBets(List<Bet> lostList) {
        lostList.forEach(bet -> this.betService.update(bet.getId(), "LOST"));
    }


}
