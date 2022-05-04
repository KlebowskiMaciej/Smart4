package com.example.demo.service;

import com.example.demo.model.CargoEntity;
import com.example.demo.repository.CargoEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
W przypadku żądanego numeru lotu i daty poda następujące informacje:
a. Waga ładunku dla żądanego lotu
b. Waga bagażu dla żądanego lotu
c. Waga całkowita dla żądanego lotu
 */
@Service
@RequiredArgsConstructor
public class CargoEntityService {

    private final CargoEntityRepository cargoEntityRepository;

    public List<CargoEntity> getCargoEntity(){

        return cargoEntityRepository.findAll();
    }

}
