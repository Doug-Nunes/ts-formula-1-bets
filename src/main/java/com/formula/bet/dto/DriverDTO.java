package com.formula.bet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("IdNumber")
    private Integer idNumber;

    @JsonProperty("Odds")
    private Integer odds;


}
