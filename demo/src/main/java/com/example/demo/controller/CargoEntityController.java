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

    //Error
    @GetMapping("/Weight/ByDate")
    private String getWeightByDate(){
        String a="2018-04-24T06:33:35 -02:00";
        return  cargoEntityService.getWeightByDate(a);
    }

    @GetMapping("/IATA/{IATA}")
    private String getIATA(@PathVariable String IATA){
        return  cargoEntityService.GetIATA(IATA);
    }
}
