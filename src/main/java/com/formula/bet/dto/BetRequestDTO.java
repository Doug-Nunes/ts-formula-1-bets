package com.formula.bet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BetRequestDTO {

    @JsonProperty(value = "UserName", required = true)
    private String userName;

    @JsonProperty(value = "DriverId", required = true)
    private Integer driverId;

    @JsonProperty(value = "amount", required = true)
    private BigDecimal amount;

    @JsonProperty(value = "SessionKey", required = true)
    private Integer sessionKey;

}
