package com.example.openschool1.controller.impl;

import com.example.openschool1.controller.PlantController;
import com.example.openschool1.converter.PlantConverter;
import com.example.openschool1.dto.PlantDto;
import com.example.openschool1.dto.PlantRequestByNameDto;
import com.example.openschool1.dto.PlantRequestByTypeDto;
import com.example.openschool1.service.PlantService;
import com.example.openschool1.utils.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlantControllerImpl implements PlantController {
    private final PlantService service;
    private final PlantConverter converter;

    @Override
    public void add(List<PlantDto> plants) {
        service.add(
                converter.convertToModel(plants)
        );
    }

    @Override
    public void add(PlantDto plantDto) {
        UserContext.setUsername("admin");
        service.add(
                converter.convertToModel(plantDto)
        );
    }

    @Override
    public PlantDto getByName(PlantRequestByNameDto dto) {
        UserContext.setUsername("admin");
        return converter.convertToDto(
                service.getByName(dto.getName())
        );
    }

    @Override
    public List<PlantDto> getByType(PlantRequestByTypeDto dto) {
        return converter.convertToDto(
                service.getByType(dto.getType())
        );
    }
}
