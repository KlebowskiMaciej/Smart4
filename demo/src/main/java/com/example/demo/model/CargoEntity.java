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
    @Column(name="flightId")
    private Long flightId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="flightId",referencedColumnName = "flightId",updatable = false, insertable = false)
    private List<Baggage> baggage = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="flightId",referencedColumnName = "flightId")
    private List<Cargo> cargo = new ArrayList<>();
}
