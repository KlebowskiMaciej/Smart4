package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CargoEntityController {

    @GetMapping("/CargoEntity")
    private List<?> getCargoEntity(){
        throw new IllegalArgumentException("Not implemented yet!");

    }
}
