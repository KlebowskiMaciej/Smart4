package com.example.demo.repository;


import com.example.demo.model.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoEntityRepository extends JpaRepository<CargoEntity, Long> {
}
