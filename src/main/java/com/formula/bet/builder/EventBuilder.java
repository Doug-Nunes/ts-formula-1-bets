package com.formula.bet.builder;

import com.formula.bet.dto.DriverDTO;
import com.formula.bet.dto.EventDTO;
import com.formula.bet.dto.openf1.DriverResponseDTO;
import com.formula.bet.dto.openf1.SessionResponseDTO;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public class EventBuilder {

    public EventDTO build(SessionResponseDTO session, List<DriverResponseDTO> drivers) {
        return EventDTO.builder()
                .circuitKey(session.getCircuitKey())
                .circuitShrotName(session.getCircuitShrotName())
                .countryCode(session.getCountryCode())
                .countryName(session.getCountryName())
                .dateEnd(session.getDateEnd())
                .dateStart(session.getDateStart())
                .gmtOffset(session.getGmtOffset())
                .location(session.getLocation())
                .meetingKey(session.getMeetingKey())
                .sessionKey(session.getSessionKey())
                .sessionName(session.getSessionName())
                .sessionType(session.getSessionType())
                .year(session.getYear())
                .drivers(getDrivers(drivers))
                .build();

    }

    private List<DriverDTO> getDrivers(List<DriverResponseDTO> drivers) {
        return drivers.stream().map(driver ->
                        new DriverDTO(driver.getFullName(),
                                driver.getDriverNumber(),
                                calculateOdds()))
                .toList();
    }

    public Integer calculateOdds() {
        return ThreadLocalRandom.current().nextInt(2, 5);
    }

}
