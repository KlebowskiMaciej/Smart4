package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class CargoEntity {
    @Id
    @Column(name="flight_id")
    private Long flightId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="flight_Id",referencedColumnName = "flight_id",updatable = false, insertable = false)
    private List<Baggage> baggage = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="flight_Id",referencedColumnName = "flight_id")
    private List<Cargo> cargo = new ArrayList<>();
}
