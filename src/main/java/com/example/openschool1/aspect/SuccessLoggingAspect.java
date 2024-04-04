package com.example.openschool1.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
@Order(1)
public class SuccessLoggingAspect {

    @AfterReturning("within(com.example.openschool1.service.*) && @within(com.example.openschool1.annotation.SuccessLogging)")
    public void successLogging(JoinPoint joinPoint){
        log.info("Метод успешно выполнился: {}", joinPoint.getSignature().toLongString());
        log.info("----------------------");
    }
}
