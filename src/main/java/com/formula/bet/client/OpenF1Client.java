package com.formula.bet.client;


import com.formula.bet.dto.openf1.DriverResponseDTO;
import com.formula.bet.dto.openf1.SessionResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "openf1", url = "${api.openf1.url}")
public interface OpenF1Client {

    @GetMapping("/sessions")
    List<SessionResponseDTO> getSessionByCountryAndNameAndYear(@RequestParam("country_name") String country,
                                                               @RequestParam("session_name") String session,
                                                               @RequestParam("year") Integer year);

    @GetMapping("/sessions")
    List<SessionResponseDTO> getSessionBySessionKey(@RequestParam("session_key") Integer sessionKey);

    @GetMapping("/drivers")
    List<DriverResponseDTO> getDriversByDriverNumberAndSessionKey(@RequestParam(name = "driver_number", required = false) Integer driverNumber,
                                                                  @RequestParam("session_key") Integer sessionKey);

    @GetMapping("/drivers")
    List<DriverResponseDTO> getDriversBySessionKey(@RequestParam("session_key") Integer sessionKey);
}
