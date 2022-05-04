package com.example.demo.service;

import com.example.demo.model.Baggage;
import com.example.demo.model.Cargo;
import com.example.demo.model.CargoEntity;
import com.example.demo.repository.BaggageRepository;
import com.example.demo.repository.CargoEntityRepository;
import com.example.demo.repository.CargoRepository;
import com.example.demo.repository.FlightEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    public String getWeight(Long id)
    {
        long CargoW=0;
        long CargoP=0;
        long BaggageW=0;
        long BaggageP=0;
        long CargoS=0;
        long BaggageS=0;
        List<CargoEntity> cargoEntities = cargoEntityRepository.findAll();
        List<Cargo> cargos = new ArrayList<>();
        List<Baggage>baggages =new ArrayList<>();

        for(CargoEntity root:cargoEntities)
        {
            if(root.getFlightId()==id)
            {
                cargos = root.getCargo();
                baggages =root.getBaggage();
            }
        }
        for (Cargo cargo : cargos) {
            if(cargo.getWeightUnit()=="lb")
                CargoW+=cargo.getWeight();
            else
                CargoW+=2.20462262*cargo.getWeight();
            CargoP+=cargo.getPieces();
        }
        for(Baggage baggage:baggages)
        {
            if(baggage.getWeightUnit()=="lb")
                BaggageW+=baggage.getWeight();
            else
                BaggageW+=2.20462262*baggage.getWeight();

            BaggageP+= baggage.getPieces();
        }

        CargoS=CargoP*CargoW;
        BaggageS=BaggageW*BaggageP;

        return "Cargo Weight for requested Flight: "+Long.toString(CargoS)+" [lb]\n"
                +"Baggage Weight for requested Flight: "+Long.toString(BaggageS)+" [lb]\n"
                +"Total Weight for requested Flight: "+Long.toString(BaggageS+CargoS)+" [lb]\n";

    }

    public String getWeightByDate(String date)
    {
        long id=0;

        return getWeight(id);
    }

}
