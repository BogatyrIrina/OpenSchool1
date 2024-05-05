package com.example.openschool1.service.impl;

import com.example.openschool1.annotation.Asynchronously;
import com.example.openschool1.annotation.PreInvoke;
import com.example.openschool1.annotation.SuccessLogging;
import com.example.openschool1.annotation.TrackAsyncTime;
import com.example.openschool1.annotation.TrackTime;
import com.example.openschool1.annotation.Valid;
import com.example.openschool1.model.Plant;
import com.example.openschool1.model.PlantException;
import com.example.openschool1.model.RoleType;
import com.example.openschool1.repository.PlantRepository;
import com.example.openschool1.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@SuccessLogging
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final PlantRepository repository;

    //private final Map<String, Plant> plants = new HashMap<>();

    @PreInvoke(roles = RoleType.ADMIN)
    @Asynchronously
    @TrackAsyncTime
    @Override
    public void addPlant(@Valid Plant plant) {
        repository.save(plant);
    }

    @PreInvoke(roles = RoleType.ADMIN)
    @Asynchronously
    @TrackAsyncTime
    @Override
    public void addPlants(@Valid List<Plant> newPlants) {
        if (newPlants.size() == 1) {
            throw new PlantException("Используйте метод addPlant(Plant plant)");
        }
        repository.saveAll(newPlants);
    }

    @PreInvoke(roles = {RoleType.ADMIN, RoleType.USER})
    @TrackTime
    @Override
    public Plant getPlantByName(String name) {
        return repository.findByName(name)
                .orElseThrow(
                        () -> new PlantException("Растение не найдено")
                );
    }

    @PreInvoke(roles = {RoleType.ADMIN, RoleType.USER})
    @TrackTime
    @Override
    public List<Plant> getPlantByType(String type) {
        return repository.findByType(type);
    }
}
