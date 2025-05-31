package com.formula.bet.controller;

import com.formula.bet.dto.BetRequestDTO;
import com.formula.bet.dto.BetResponseDTO;
import com.formula.bet.dto.DetailedResponseDTO;
import com.formula.bet.dto.EventDTO;
import com.formula.bet.service.FormulaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formula")
@RequiredArgsConstructor
@Tag(name = "Formula", description = "Endpoints for Formula 1 betting")
public class FormulaController {

    private final FormulaService formulaService;

    @GetMapping("/events")
    @Operation(summary = "Get events by session type, year, and country",
            description = "Returns a list of events based on the specified session type, year, and country.")
    public ResponseEntity<List<EventDTO>> getEvents(@RequestParam String sessionType,
                                                    @RequestParam Integer year,
                                                    @RequestParam String country){
        var response = this.formulaService.getEventsAndDriverMarket(sessionType, year, country);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/bet")
    @Operation(summary = "Place a bet",
            description = "Generates a bet based on the provided user name, driver number, session key, and amount.")
    public ResponseEntity<BetResponseDTO> postBet(@RequestBody BetRequestDTO betRequestDTO){
        var response = this.formulaService.generateBet(betRequestDTO);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/outcome")
    @Operation(summary = "Get outcome of a driver",
            description = "Triggers the outcome event for a specific driver based on session key and driver ID.")
    public ResponseEntity<DetailedResponseDTO> getOutCome(@RequestParam Integer sessionKey,
                                             @RequestParam Integer driverId){
        this.formulaService.eventOutCome(sessionKey, driverId);
        return ResponseEntity.ok(DetailedResponseDTO.ok());
    }


}
