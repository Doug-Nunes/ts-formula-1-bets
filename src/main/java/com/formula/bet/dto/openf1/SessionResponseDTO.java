package com.formula.bet.dto.openf1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SessionResponseDTO {

    @JsonProperty("circuit_key")
    private String circuitKey;

    @JsonProperty("circuit_short_name")
    private String circuitShrotName;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("date_end")
    private String dateEnd;

    @JsonProperty("date_start")
    private String dateStart;

    @JsonProperty("gmt_offset")
    private String gmtOffset;

    @JsonProperty("location")
    private String location;

    @JsonProperty("meeting_key")
    private String meetingKey;

    @JsonProperty("session_key")
    private Integer sessionKey;

    @JsonProperty("session_name")
    private String sessionName;

    @JsonProperty("session_type")
    private String sessionType;

    @JsonProperty("year")
    private String year;
}
