package com.example.openschool1.converter;

import com.example.openschool1.dto.PlantDto;
import com.example.openschool1.model.Plant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlantConverter {
    PlantDto convertToDto(Plant plant);

    Plant convertToModel(PlantDto plantDto);

    List<PlantDto> convertToDto(List<Plant> plant);

    List<Plant> convertToModel(List<PlantDto> plantDto);

}
