package com.example.openschool1.service.impl;

import com.example.openschool1.model.TrackTimeMethod;
import com.example.openschool1.service.ExecutionTimeService;
import com.example.openschool1.service.TrackTimeMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExecutionTimeServiceImpl implements ExecutionTimeService {

    private final TrackTimeMethodService service;

    @Override
    public Long getAverageByClassNameAndMethodName(String className, String methodName) {
        return this.getAverage(
                this.getByClassNameAndMethodName(className, methodName)
        );
    }

    @Override
    public Long getAverageByClassName(String className) {
        return this.getAverage(
                this.getByClassName(className)
        );
    }

    @Override
    public Long getTotalByClassNameAndMethodName(String className, String methodName) {
        return this.getTotal(
                this.getByClassNameAndMethodName(className, methodName)
        );
    }

    @Override
    public Long getTotalByClassName(String className) {
        return this.getTotal(
                this.getByClassName(className)
        );
    }

    @Override
    public Long getAverageAll() {
        return this.getAverage(
                this.getAll()
        );
    }

    @Override
    public Long getTotalAll() {
        return this.getTotal(
                this.getAll()
        );
    }

    private List<Long> getByClassNameAndMethodName(String className, String methodName) {
        return service.getByClassNameAndMethodName(className, methodName).stream()
                .map(TrackTimeMethod::getExecutionTime)
                .toList();
    }

    private List<Long> getByClassName(String className) {
        return service.getByClassName(className).stream()
                .map(TrackTimeMethod::getExecutionTime)
                .toList();
    }

    private List<Long> getAll() {
        return service.getAll().stream()
                .map(TrackTimeMethod::getExecutionTime)
                .toList();
    }

    private Long getAverage(List<Long> times) {
        long average = 0L;
        for (long time : times) {
            average += time;
        }
        return average / times.size();
    }

    private Long getTotal(List<Long> times) {
        long average = 0L;
        for (long time : times) {
            average += time;
        }
        return average;
    }
}
