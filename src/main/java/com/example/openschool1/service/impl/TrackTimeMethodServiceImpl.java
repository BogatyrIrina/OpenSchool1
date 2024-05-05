package com.example.openschool1.service.impl;

import com.example.openschool1.model.TrackTimeMethod;
import com.example.openschool1.repository.TrackTimeMethodRepository;
import com.example.openschool1.service.TrackTimeMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TrackTimeMethodServiceImpl implements TrackTimeMethodService {
    private final TrackTimeMethodRepository repository;

    @Override
    public List<TrackTimeMethod> getByMethodName(String methodName) {
        return repository.findByMethodName(methodName);
    }

    @Override
    public List<TrackTimeMethod> getByClassName(String className) {
        return repository.findByClassName(className);
    }

    @Override
    public List<TrackTimeMethod> getByClassNameAndMethodName(String className, String methodName) {
        return repository.findByClassNameAndMethodName(className, methodName);
    }

    @Override
    public List<TrackTimeMethod> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(TrackTimeMethod trackTimeMethod) {
        repository.save(trackTimeMethod);
    }
}
