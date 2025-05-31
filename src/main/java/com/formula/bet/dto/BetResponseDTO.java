package com.formula.bet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class BetResponseDTO {

    @JsonProperty("User")
    private String user;

    @JsonProperty("Driver")
    private String driver;

    @JsonProperty("Amount")
    private BigDecimal amount;

    @JsonProperty("Status")
    private String status;
}
