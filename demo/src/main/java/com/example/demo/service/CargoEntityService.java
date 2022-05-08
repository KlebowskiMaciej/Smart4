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
    /**
     * CargoEntityService's a class with 3 methods and two declared repositories.
     */

    /**
     * repository declaration
     */
    private final CargoEntityRepository cargoEntityRepository;
    private final FlightEntityRepository flightEntityRepository;


    /**
     * WeightList method is a method that returns a 3 element array. In which, for the given flight id, there is the total weight, Cargo weight, Baggage weight.
     * @param id  The id of the flight for which the method should execute
     * @return 3 element Long type board [0] - Cargo weight, [1] - Baggage weight, [2] - Total weight.
     */
    public ArrayList<Long> WeightList(Long id){
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

    /**
     * Method searching if a flight with the given number exists and returning String with Cargo weight, Baggage weight, Total weight
     * @param FlightNumber The number of the flight for which you are looking for data.
     * @return String containing information about baggage weight, baggage weight and total weight.
     */
    public String GetByFlightNumber(Long FlightNumber)
    {
       boolean exist=false;
        ArrayList<Long> Weight = new ArrayList<>();
        List<FlightEntity>flightEntityList = flightEntityRepository.findAll();
            for(FlightEntity flightEntity:flightEntityList)
            {
                Long id=flightEntity.getFlightNumber();
                if(id.equals(FlightNumber)) {
                    id = flightEntity.getFlightId();
                    Weight=WeightList(id);
                    exist=true;
                    break;
                }
            }
        if(!exist)
            return "There is no flight with this FlightNumber!";

        return "Cargo Weight for requested Flight: "+Long.toString(Weight.get(0))+" [lb] "
                +"Baggage Weight for requested Flight: "+Long.toString(Weight.get(1))+" [lb] "
                +"Total Weight for requested Flight: "+Long.toString(Weight.get(2))+" [lb] ";

    }

    /**
     * The method returns information about the flight from or to the specified IATA airport code.
     * It tells us how many such flights there are and what is the total luggage weight. For departures and arrivals.
     * @param IATA The IATA airport code for which the method is searching.
     * @return String containing the number of departing and arriving flights and the total amount of baggage for departures and arrivals.
     */
    public String GetByIATA(String IATA)
    {
        List<FlightEntity>flightEntityList = flightEntityRepository.findAll();
        String sum="";
        long TotalA=0;
        long TotalD=0;
        long id=0;
        long flightDeparting=0;
        long flightArriving=0;
        boolean exist=false;
        for(FlightEntity flightEntity:flightEntityList) {
            sum = flightEntity.getArrivalAirportIATACode().toString();
            if (sum.equals(IATA)) {
                flightArriving += 1;
                id= flightEntity.getFlightId();
                TotalA+=WeightList(id).get(1);
                exist=true;
            }
            sum=flightEntity.getDepartureAirportIATACode();
            if(sum.equals(IATA)) {
                flightDeparting += 1;
                id= flightEntity.getFlightId();
                TotalD+=WeightList(id).get(1);
                exist=true;
            }
        }
        if(!exist)
            return "There is no flight with this IATA!";

        return "Number of flights departing from this airport: "+flightDeparting+" Total number (pieces) of baggage departing from this airport: "+TotalD+" [lb] \n"
                +"Number of flights arriving to this airport: "+flightArriving+" Total number (pieces) of baggage arriving to this airport: "+TotalA+" [lb] \n";
    }


}
