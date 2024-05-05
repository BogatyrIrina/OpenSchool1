package com.example.openschool1.repository;

import com.example.openschool1.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    Optional<Plant> findByName(String name);

    List<Plant> findByType(String type);
}
