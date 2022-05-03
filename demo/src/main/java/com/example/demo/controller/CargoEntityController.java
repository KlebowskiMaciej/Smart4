package com.example.demo.controller;

import com.example.demo.model.CargoEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CargoEntityController {

    @GetMapping("/CargoEntity")
    private List<CargoEntity> getCargoEntity(){
        throw new IllegalArgumentException("Not implemented yet!");

    }
    @GetMapping("/CargoEntity/{flight_id}")
    private CargoEntity getSingleCargoEntity(@PathVariable Long flight_id){
        throw new IllegalArgumentException("Not implemented yet!");

    }
}
