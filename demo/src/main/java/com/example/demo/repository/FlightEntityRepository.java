package com.example.demo.repository;

import com.example.demo.model.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightEntityRepository extends JpaRepository<FlightEntity,Long> {
}
