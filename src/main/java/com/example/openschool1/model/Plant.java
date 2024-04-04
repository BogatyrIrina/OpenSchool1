package com.example.openschool1.model;

import com.example.openschool1.annotation.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Model
public class Plant {
    private String name;
    private String type;


}
