package com.formula.bet.service;

import com.formula.bet.builder.EventBuilder;
import com.formula.bet.dto.openf1.DriverResponseDTO;
import com.formula.bet.model.Driver;
import com.formula.bet.model.EventSession;
import com.formula.bet.respository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    public Driver save(DriverResponseDTO driverResponseDTO, EventSession eventSession) {
        var driverExisted = findByIdNumber(driverResponseDTO.getDriverNumber());
        if(driverExisted != null){
            return driverExisted;
        }

        Driver driver =  new Driver();
        driver.setFullName(driverResponseDTO.getFullName());
        driver.setIdNumber(driverResponseDTO.getDriverNumber());
        driver.setOdds(EventBuilder.calculateOdds());
        driver.setEventSession(eventSession);
        return this.driverRepository.save(driver);
    }

    private Driver findByIdNumber(Integer idNumber) {
        return this.driverRepository.findByIdNumber(idNumber);
    }
}
