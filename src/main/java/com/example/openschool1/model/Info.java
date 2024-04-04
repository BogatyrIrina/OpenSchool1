package com.example.openschool1.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Info {

    @Autowired
    @Lazy
    private Info info;
    public void info(){
        log.info("INFO METHOD");
    }

    public void method1(){
        log.info("первый метод");
        info.method2();
    }

    public void method2(){
        log.info("второй метод");
    }
}
