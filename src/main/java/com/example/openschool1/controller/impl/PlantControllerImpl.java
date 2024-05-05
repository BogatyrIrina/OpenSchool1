package com.example.openschool1.controller.impl;

import com.example.openschool1.controller.PlantController;
import com.example.openschool1.converter.PlantConverter;
import com.example.openschool1.dto.PlantDto;
import com.example.openschool1.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlantControllerImpl implements PlantController {
    private final PlantService service;
    private final PlantConverter converter;

    @Override
    public PlantDto getByName(String name) {
        return converter.convertToDto(
                service.getPlantByName(name)
        );
    }

    @Override
    public void add(List<PlantDto> plants) {
        service.addPlants(
                converter.convertToModel(plants)
        );
    }

    @Override
    public void add(PlantDto plantDto) {
        service.addPlant(
                converter.convertToModel(plantDto)
        );
    }

    @Override
    public List<PlantDto> getByType(String type) {
        return converter.convertToDto(
                service.getPlantByType(type)
        );
    }
}
