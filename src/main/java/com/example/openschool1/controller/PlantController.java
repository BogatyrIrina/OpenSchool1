package com.example.openschool1.controller;

import com.example.openschool1.dto.PlantDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.example.openschool1.constant.UrlConstant.ALL_URL;
import static com.example.openschool1.constant.UrlConstant.NAME_PATH_VARIABLE;
import static com.example.openschool1.constant.UrlConstant.NAME_PATH_VARIABLE_URL;
import static com.example.openschool1.constant.UrlConstant.PLANTS_URL;
import static com.example.openschool1.constant.UrlConstant.TYPE_PATH_VARIABLE;
import static com.example.openschool1.constant.UrlConstant.TYPE_PATH_VARIABLE_URL;

@RequestMapping(PLANTS_URL)
public interface PlantController {

    @GetMapping(NAME_PATH_VARIABLE_URL)
    PlantDto getByName(@PathVariable(NAME_PATH_VARIABLE) String name);

    @PostMapping(ALL_URL)
    void add(@RequestBody List<PlantDto> plants);

    @PostMapping
    void add(@RequestBody PlantDto plantDto);

    @GetMapping(TYPE_PATH_VARIABLE_URL)
    List<PlantDto> getByType(@PathVariable(TYPE_PATH_VARIABLE) String type);
}
