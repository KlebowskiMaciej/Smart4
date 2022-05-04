package com.example.demo.service;

import com.example.demo.model.CargoEntity;
import com.example.demo.repository.BaggageRepository;
import com.example.demo.repository.CargoEntityRepository;
import com.example.demo.repository.CargoRepository;
import com.example.demo.repository.FlightEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
W przypadku żądanego numeru lotu i daty poda następujące informacje:
a. Waga ładunku dla żądanego lotu
b. Waga bagażu dla żądanego lotu
c. Waga całkowita dla żądanego lotu
 */
/*
W przypadku żądania podania kodu lotniska IATA i daty, odpowiedź będzie następująca:
a. Liczba lotów rozpoczynających się z tego lotniska,
b. Liczba lotów przylatujących na to lotnisko,
c. łączną liczbę (sztuk) bagażu przybywającego do tego portu lotniczego,
d. łączną liczbę (sztuk) bagażu odlatującego z tego portu lotniczego.
 */
@Service
@RequiredArgsConstructor
public class CargoEntityService {

    private final CargoEntityRepository cargoEntityRepository;
    private final CargoRepository cargoRepository;
    private final FlightEntityRepository flightEntityRepository;
    private final BaggageRepository baggageRepository;


    public List<CargoEntity> getCargoEntity(){

        return cargoEntityRepository.findAll();
    }

    public String getWeight()
    {

        return "work";
    }

}
