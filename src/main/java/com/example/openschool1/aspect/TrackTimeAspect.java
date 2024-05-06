package com.example.openschool1.aspect;

import com.example.openschool1.model.TrackTimeMethod;
import com.example.openschool1.service.TrackTimeMethodService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
@ConditionalOnProperty(
        value = "aspect.enabled",
        havingValue = "true"
)
public class TrackTimeAspect {
    private final TrackTimeMethodService service;

    @Around("execution(@com.example.openschool1.annotation.TrackTime public * get*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] methodArgs = proceedingJoinPoint.getArgs();

        log.info("Выполнение метода {} с аргументами {}", methodName, methodArgs);

        Object result = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        service.add(
                TrackTimeMethod.builder()
                        .className(
                                proceedingJoinPoint
                                        .getTarget()
                                        .getClass()
                                        .getCanonicalName()
                        ).methodName(methodName)
                        .callTime(LocalDateTime.now())
                        .executionTime(executionTime)
                        .build()
        );

        log.info("Метод {} выполнился за {} мс с результатом {}", methodName, executionTime, result);

        return result;
    }
}
