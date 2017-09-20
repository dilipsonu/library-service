package com.dk.library.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Component
@Configuration
@Slf4j
public class MDCLoggingAspectConfiguration {

    private static final String REQUEST_ID = "requestId";

    @Before (
            "execution(* com.dk.library" +
            ".controller..*.*(..))")
    public void mdcPut(JoinPoint joinPoint) {
        MDC.put(REQUEST_ID,
                UUID.randomUUID().toString().replace("-", "").substring(0, 12));
    }

    @AfterThrowing (pointcut = "execution(* com.dk.library" +
                               ".controller..*.*(..))", throwing = "ex")
    public void mdcRemove(JoinPoint joinPoint, Exception ex) {
        log.error("An exception has occurred when trying to process a request",
                  ex);
    }
}
