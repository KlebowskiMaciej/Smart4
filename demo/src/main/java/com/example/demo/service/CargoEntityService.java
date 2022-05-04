package com.example.demo.service;

import com.example.demo.model.Baggage;
import com.example.demo.model.Cargo;
import com.example.demo.model.CargoEntity;
import com.example.demo.model.FlightEntity;
import com.example.demo.repository.CargoEntityRepository;
import com.example.demo.repository.FlightEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class CargoEntityService {

    private final CargoEntityRepository cargoEntityRepository;
    private final FlightEntityRepository flightEntityRepository;


    public List<CargoEntity> getCargoEntity(){

        return cargoEntityRepository.findAll();
    }
    private ArrayList<Long> WeightList(Long id){
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
            if(root.getFlightId().equals(id))
            {
                cargos = root.getCargo();
                baggages =root.getBaggage();
            }
        }
        for (Cargo cargo : cargos) {
            if(cargo.getWeightUnit().equals("lb"))
                CargoW+=cargo.getWeight();
            else
                CargoW+=2.20462262*cargo.getWeight();
            CargoP+=cargo.getPieces();
        }
        for(Baggage baggage:baggages)
        {
            if(baggage.getWeightUnit().equals("lb"))
                BaggageW+=baggage.getWeight();
            else
                BaggageW+=2.20462262*baggage.getWeight();

            BaggageP+= baggage.getPieces();
        }

        CargoS=CargoP*CargoW;
        BaggageS=BaggageW*BaggageP;

        ArrayList<Long> answer = new ArrayList<>();
        answer.add(CargoS);
        answer.add(BaggageS);
        answer.add(CargoS+BaggageS);

        return answer;
    }

    public String getWeight(Long id)
    {
       ArrayList<Long> Weight=WeightList(id);

        return "Cargo Weight for requested Flight: "+Long.toString(Weight.get(0))+" [lb]\n"
                +"Baggage Weight for requested Flight: "+Long.toString(Weight.get(1))+" [lb]\n"
                +"Total Weight for requested Flight: "+Long.toString(Weight.get(2))+" [lb]\n";

    }

    public String getWeightByDate(String date)
    {
        long id=0;
        List<FlightEntity>flightEntityList = flightEntityRepository.findAll();
        for(FlightEntity flightEntity:flightEntityList)
        {
            String s=flightEntity.getDepartureDate();
            if(s.equals(date))
                id=flightEntity.getFlightId();
            else
                return "No data available";
        }
        return getWeight(id);
    }

    public String GetIATA(String IATA)
    {
        List<FlightEntity>flightEntityList = flightEntityRepository.findAll();
        String sum="";
        long TotalA=0;
        long TotalD=0;
        long id=0;
        long flightDeparting=0;
        long flightArriving=0;
        for(FlightEntity flightEntity:flightEntityList) {
            sum = flightEntity.getArrivalAirportIATACode().toString();
            if (sum.equals(IATA)) {
                flightArriving += 1;
                id= flightEntity.getFlightId();
                TotalA+=WeightList(id).get(1);
            }
            sum=flightEntity.getDepartureAirportIATACode();
            if(sum.equals(IATA)) {
                flightDeparting += 1;
                id= flightEntity.getFlightId();
                TotalD+=WeightList(id).get(1);
            }
        }
        return "Number of flights departing from this airport: "+flightDeparting+" Total number (pieces) of baggage departing from this airport: "+TotalD+" [lb] \n"
                +"Number of flights arriving to this airport: "+flightArriving+" Total number (pieces) of baggage arriving to this airport: "+TotalA+" [lb] \n";
    }

}
