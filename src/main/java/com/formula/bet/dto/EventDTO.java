package com.formula.bet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class EventDTO {

    @JsonProperty("CircuitKey")
    private String circuitKey;

    @JsonProperty("CircuitShortName")
    private String circuitShrotName;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("CountryName")
    private String countryName;

    @JsonProperty("DateEnd")
    private String dateEnd;

    @JsonProperty("DateStart")
    private String dateStart;

    @JsonProperty("GmtOffset")
    private String gmtOffset;

    @JsonProperty("Location")
    private String location;

    @JsonProperty("MeetingKey")
    private String meetingKey;

    @JsonProperty("SessionKey")
    private Integer sessionKey;

    @JsonProperty("SessionName")
    private String sessionName;

    @JsonProperty("SessionType")
    private String sessionType;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Drivers")
    private List<DriverDTO> drivers;

}
