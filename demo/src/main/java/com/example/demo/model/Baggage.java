package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Baggage {

    @Id
    private Long id;
    private Long weight;
    private String weightUnit;
    private Long pieces;
}


