package com.example.openschool1.service;

import com.example.openschool1.model.TrackTimeMethod;

import java.util.List;

public interface TrackTimeMethodService {
    List<TrackTimeMethod> getByMethodName(String methodName);
    List<TrackTimeMethod> getByClassName(String className);
    List<TrackTimeMethod> getByClassNameAndMethodName(String className, String methodName);
    List<TrackTimeMethod> getAll();
    void add(TrackTimeMethod trackTimeMethod);
}
