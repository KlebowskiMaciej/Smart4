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
    @GetMapping("/Weight/{id}")
    private String getWeight(@PathVariable long id){
        return  cargoEntityService.getWeight(id);

    }
}
