package com.example.demo.controller;

import com.example.demo.model.CargoEntity;
import com.example.demo.service.CargoEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CargoEntityController {

    private final CargoEntityService cargoEntityService;
    @GetMapping("/CargoEntity")
    private List<CargoEntity> getCargoEntity(){
        return  cargoEntityService.getCargoEntity();

    }
    @GetMapping("/Cargo")
    private String getWeight(){
        return  cargoEntityService.getWeight();

    }
    @GetMapping("/CargoEntity/{flight_id}")
    private CargoEntity getSingleCargoEntity(@PathVariable Long flight_id){
        throw new IllegalArgumentException("Not implemented yet!");

    }
}
