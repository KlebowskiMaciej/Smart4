package com.example.demo.controller;


import com.example.demo.service.CargoEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CargoEntityController {

    private final CargoEntityService cargoEntityService;

    @GetMapping("/FlightNumber/{flightNumber}")
    private String getWeight(@PathVariable long flightNumber){
        return  cargoEntityService.getByFlightNumber(flightNumber);
    }

    @GetMapping("/IATA/{IATA}")
    private String getIATA(@PathVariable String IATA){
        return  cargoEntityService.getByIATA(IATA);
    }
}
