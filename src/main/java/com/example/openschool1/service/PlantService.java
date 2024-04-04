package com.example.openschool1.service;

import com.example.openschool1.annotation.Asynchronously;
import com.example.openschool1.annotation.PreInvoke;
import com.example.openschool1.annotation.SuccessLogging;
import com.example.openschool1.annotation.Valid;
import com.example.openschool1.model.Plant;
import com.example.openschool1.model.PlantException;
import com.example.openschool1.model.RoleType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@SuccessLogging
public class PlantService {

    private final Map<String, Plant> plants = new HashMap<>();

    @PreInvoke(roles = RoleType.ADMIN)
    @Asynchronously
    public void addPlant(@Valid Plant plant){
        plants.put(plant.getName(), plant);
    }

    @PreInvoke(roles = RoleType.ADMIN)
    @Asynchronously
    public void addPlants(@Valid List<Plant> newPlants){
        if (newPlants.size() == 1){
            throw new PlantException("Используйте метод addPlant(Plant plant)");
        }

        plants.putAll(newPlants.stream().collect(Collectors.toMap(Plant::getName, Function.identity())));
    }

    @PreInvoke(roles = {RoleType.ADMIN, RoleType.USER})
    public Plant getPlantByName(String name){
        return plants.get(name);
    }

    @PreInvoke(roles = {RoleType.ADMIN, RoleType.USER})
    public List<Plant> getPlantByType(String type){
        return plants.values().stream().filter(plant -> plant.getType().equals(type)).collect(Collectors.toList());
    }
}
