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
import java.util.concurrent.CompletableFuture;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
@ConditionalOnProperty(
        value = "aspect.enabled",
        havingValue = "true"
)
public class TrackAsyncTimeAspect {

    private final TrackTimeMethodService service;

    @Around("execution(@com.example.openschool1.annotation.TrackAsyncTime public void add*(..)) ")
    public Object trackTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] methodArgs = proceedingJoinPoint.getArgs();

        log.info("Выполнение метода {} с аргументами {}", methodName, methodArgs);

        Object result = proceedingJoinPoint.proceed();

        CompletableFuture future = (CompletableFuture) result;
        future.thenAccept(
                f -> {
                    long executionTime = System.currentTimeMillis() - startTime;

                    service.add(
                            TrackTimeMethod.builder()
                                    .className(proceedingJoinPoint.getTarget().getClass().getCanonicalName())
                                    .methodName(methodName)
                                    .callTime(LocalDateTime.now())
                                    .executionTime(executionTime)
                                    .build()
                    );

                    log.info("Метод {} выполнился за {} мс с результатом {}",
                            methodName, executionTime, result);
                }
        );
        return result;
    }
}
