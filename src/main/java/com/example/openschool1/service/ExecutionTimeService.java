package com.example.openschool1.service;

public interface ExecutionTimeService {
    Long getAverageByClassNameAndMethodName(String className, String methodName);
    Long getAverageByClassName(String className);
    Long getTotalByClassNameAndMethodName(String className, String methodName);
    Long getTotalByClassName(String className);
    Long getAverageAll();
    Long getTotalAll();
}
