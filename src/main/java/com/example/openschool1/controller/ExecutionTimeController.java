package com.example.openschool1.controller;

import com.example.openschool1.dto.ExecutionTimeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.openschool1.constant.UrlConstant.AVERAGE_URL;
import static com.example.openschool1.constant.UrlConstant.CLASS_NAME_PATH_VARIABLE;
import static com.example.openschool1.constant.UrlConstant.CLASS_NAME_PATH_VARIABLE_URL;
import static com.example.openschool1.constant.UrlConstant.EXECUTION_TIME_URL;
import static com.example.openschool1.constant.UrlConstant.METHOD_NAME_PATH_VARIABLE;
import static com.example.openschool1.constant.UrlConstant.METHOD_NAME_PATH_VARIABLE_URL;
import static com.example.openschool1.constant.UrlConstant.TOTAL_URL;

@RequestMapping(EXECUTION_TIME_URL)
public interface ExecutionTimeController {

    @GetMapping(AVERAGE_URL + CLASS_NAME_PATH_VARIABLE_URL + METHOD_NAME_PATH_VARIABLE_URL)
    ExecutionTimeDto getAverageByClassNameAndMethodName(
            @PathVariable(CLASS_NAME_PATH_VARIABLE) String className,
            @PathVariable(METHOD_NAME_PATH_VARIABLE) String methodName
    );

    @GetMapping(AVERAGE_URL + CLASS_NAME_PATH_VARIABLE_URL)
    ExecutionTimeDto getAverageByClassName(
            @PathVariable(CLASS_NAME_PATH_VARIABLE) String className
    );

    @GetMapping(TOTAL_URL + CLASS_NAME_PATH_VARIABLE_URL + METHOD_NAME_PATH_VARIABLE_URL)
    ExecutionTimeDto getTotalByClassNameAndMethodName(
            @PathVariable(CLASS_NAME_PATH_VARIABLE) String className,
            @PathVariable(METHOD_NAME_PATH_VARIABLE) String methodName
    );

    @GetMapping(TOTAL_URL + CLASS_NAME_PATH_VARIABLE_URL)
    ExecutionTimeDto getTotalByClassName(
            @PathVariable(CLASS_NAME_PATH_VARIABLE) String className
    );

    @GetMapping(AVERAGE_URL)
    ExecutionTimeDto getAverageAll();

    @GetMapping(TOTAL_URL)
    ExecutionTimeDto getTotalAll();
}
