package com.example.openschool1.service.impl;

import com.example.openschool1.annotation.PreInvoke;
import com.example.openschool1.annotation.SuccessLogging;
import com.example.openschool1.annotation.TrackAsyncTime;
import com.example.openschool1.annotation.TrackTime;
import com.example.openschool1.annotation.Valid;
import com.example.openschool1.exception.PlantException;
import com.example.openschool1.model.Plant;
import com.example.openschool1.model.RoleType;
import com.example.openschool1.repository.PlantRepository;
import com.example.openschool1.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuccessLogging
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {
    private final PlantRepository repository;

    @PreInvoke(roles = RoleType.ADMIN)
    @TrackAsyncTime
    @Override
    public void add(@Valid Plant plant) {
        repository.save(plant);
    }

    @PreInvoke(roles = RoleType.ADMIN)
    @TrackAsyncTime
    @Override
    public void add(@Valid List<Plant> newPlants) {
        if (newPlants.size() == 1) {
            throw new PlantException("Используйте метод addPlant(Plant plant)");
        }
        repository.saveAll(newPlants);
    }

    @PreInvoke(roles = {RoleType.ADMIN, RoleType.USER})
    @TrackTime
    @Override
    public Plant getByName(String name) {
        return repository.findByName(name)
                .orElseThrow(
                        () -> new PlantException("Растение не найдено")
                );
    }

    @PreInvoke(roles = {RoleType.ADMIN, RoleType.USER})
    @TrackTime
    @Override
    public List<Plant> getByType(String type) {
        return repository.findByType(type);
    }
}
