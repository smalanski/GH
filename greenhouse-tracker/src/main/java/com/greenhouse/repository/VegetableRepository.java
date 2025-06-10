package com.greenhouse.repository;

import com.greenhouse.model.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    List<Vegetable> findByGreenhouseId(Long greenhouseId);
    List<Vegetable> findByNameContainingIgnoreCase(String name);
    List<Vegetable> findByPlantingDateBetween(LocalDate start, LocalDate end);
    List<Vegetable> findByExpectedHarvestDateBefore(LocalDate date);
    List<Vegetable> findByLastWateringIsNull();
}
