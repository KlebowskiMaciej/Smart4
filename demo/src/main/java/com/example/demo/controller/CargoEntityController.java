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

    @GetMapping("/FlightNumber/{FlightNumber}")
    private String GetWeight(@PathVariable long FlightNumber){
        return  cargoEntityService.GetByFlightNumber(FlightNumber);
    }

    @GetMapping("/IATA/{IATA}")
    private String GetIATA(@PathVariable String IATA){
        return  cargoEntityService.GetByIATA(IATA);
    }
}
