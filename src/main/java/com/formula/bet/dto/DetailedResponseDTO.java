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
public class DetailedResponseDTO {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Status")
    private String status;


    public static DetailedResponseDTO ok() {
        DetailedResponseDTO response = new DetailedResponseDTO();
        response.setTitle("Event Sucessfully");
        response.setMessage("Event has been triggered successfully.");
        response.setStatus("200 OK");
        return response;
    }
}
