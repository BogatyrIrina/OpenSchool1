package com.example.openschool1;

import com.example.openschool1.model.Plant;
import com.example.openschool1.service.PlantService;
import com.example.openschool1.utils.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
@SpringBootApplication
public class OpenSchool1Application {

    //private final Info info;
    private final PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(OpenSchool1Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onReady() {
        //info.info();

        UserContext.setUsername("admin");
        plantService.addPlant(new Plant("Роза", "Цветок"));
        System.out.println(plantService.getPlantByType("Цветок"));
        System.out.println(plantService.getPlantByName("Роза"));


    }
}
