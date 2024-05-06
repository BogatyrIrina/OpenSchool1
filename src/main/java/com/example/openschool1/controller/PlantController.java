package com.example.openschool1.controller;

import com.example.openschool1.dto.PlantDto;
import com.example.openschool1.dto.PlantRequestByNameDto;
import com.example.openschool1.dto.PlantRequestByTypeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.example.openschool1.constant.UrlConstant.ALL_URL;
import static com.example.openschool1.constant.UrlConstant.NAME_URL;
import static com.example.openschool1.constant.UrlConstant.PLANTS_URL;
import static com.example.openschool1.constant.UrlConstant.TYPE_URL;

@RequestMapping(PLANTS_URL)
public interface PlantController {

    @PostMapping(ALL_URL)
    void add(@RequestBody List<PlantDto> plants);

    @PostMapping
    void add(@RequestBody PlantDto plantDto);

    @GetMapping(NAME_URL)
    PlantDto getByName(@RequestBody PlantRequestByNameDto dto);

    @GetMapping(TYPE_URL)
    List<PlantDto> getByType(@RequestBody PlantRequestByTypeDto dto);
}