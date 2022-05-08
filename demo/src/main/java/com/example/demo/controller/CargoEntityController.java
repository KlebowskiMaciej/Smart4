package com.example.demo.controller;


import com.example.demo.service.CargoEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CargoEntityController {
    /**
     * Controller class having two mapped methods to see the results.
     * @link localhost:8080/FlightNumber/7078   Allows you to get the GetWeight method call for the given flight number.
     * @link localhost:8080/IATA/SEA            Allows you to get the GetIATA method call for the given IATA .
     */
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
