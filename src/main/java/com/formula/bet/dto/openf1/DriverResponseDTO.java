package com.formula.bet.dto.openf1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DriverResponseDTO {

    @JsonProperty("broadcast_name")
    private String broadCastName;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("driver_number")
    private Integer driverNumber;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("headshot_url")
    private String headshotUrl;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("meeting_key")
    private Integer meetingKey;

    @JsonProperty("name_acronym")
    private String nameAcronym;

    @JsonProperty("team_colour")
    private String teamColour;

    @JsonProperty("team_name")
    private String teamName;


}



