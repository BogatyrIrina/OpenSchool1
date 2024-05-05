package com.example.openschool1.service;

import com.example.openschool1.annotation.Valid;
import com.example.openschool1.model.Plant;

import java.util.List;

public interface PlantService {
    void addPlant(@Valid Plant plant);
    void addPlants(@Valid List<Plant> newPlants);
    Plant getPlantByName(String name);
    List<Plant> getPlantByType(String type);
}
