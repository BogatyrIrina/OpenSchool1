package com.example.openschool1.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Aspect
@Slf4j
public class TrackAsyncTimeAspect {

    @Around("execution(@com.example.openschool1.annotation.TrackAsyncTime public void add*(..)) ")
    public Object trackTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] methodArgs = proceedingJoinPoint.getArgs();

        log.info("Выполнение метода {} с аргументами {}", methodName, methodArgs);

        Object result = proceedingJoinPoint.proceed();
        CompletableFuture future = (CompletableFuture) result;
        future.thenAccept(
                f -> log.info("Метод {} выполнился за {} мс с результатом {}", methodName,
                                System.currentTimeMillis() - startTime, result)
        );
        return result;
    }
}
