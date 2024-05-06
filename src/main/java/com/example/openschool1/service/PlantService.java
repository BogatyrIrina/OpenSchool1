package com.example.openschool1.service;

import com.example.openschool1.annotation.Valid;
import com.example.openschool1.model.Plant;

import java.util.List;

public interface PlantService {
    void add(@Valid Plant plant);
    void add(@Valid List<Plant> newPlants);
    Plant getByName(String name);
    List<Plant> getByType(String type);
}
