package com.example.openschool1.controller.impl;

import com.example.openschool1.controller.ExecutionTimeController;
import com.example.openschool1.dto.ExecutionTimeDto;
import com.example.openschool1.service.ExecutionTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ExecutionTimeControllerImpl implements ExecutionTimeController {

    private final ExecutionTimeService service;

    @Override
    public ExecutionTimeDto getAverageByClassNameAndMethodName(String className, String methodName) {
        return ExecutionTimeDto.builder()
                .executionTime(
                        service.getAverageByClassNameAndMethodName(className, methodName)
                ).build();
    }

    @Override
    public ExecutionTimeDto getAverageByClassName(String className) {
        return ExecutionTimeDto.builder()
                .executionTime(
                        service.getAverageByClassName(className)
                ).build();
    }

    @Override
    public ExecutionTimeDto getTotalByClassNameAndMethodName(String className, String methodName) {
        return ExecutionTimeDto.builder()
                .executionTime(
                        service.getTotalByClassNameAndMethodName(className, methodName)
                ).build();
    }

    @Override
    public ExecutionTimeDto getTotalByClassName(String className) {
        return ExecutionTimeDto.builder()
                .executionTime(
                        service.getTotalByClassName(className)
                ).build();
    }

    @Override
    public ExecutionTimeDto getAverageAll() {
        return ExecutionTimeDto.builder()
                .executionTime(
                        service.getAverageAll()
                ).build();
    }

    @Override
    public ExecutionTimeDto getTotalAll() {
        return ExecutionTimeDto.builder()
                .executionTime(
                        service.getTotalAll()
                ).build();
    }
}
