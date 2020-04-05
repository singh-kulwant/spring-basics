package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {

    }

    @Before("executeLogging()")
    public void logMethodCall(JoinPoint joinPoint) {
        StringBuilder message = new StringBuilder("method:[");
        message.append(joinPoint.getSignature().getName());
        message.append("], ");
        Object[] args = joinPoint.getArgs();
        if (null != args && args.length > 0) {
            message.append("args:[");
            Arrays.asList(args).forEach(arg -> message.append("arg=").append(arg).append("|"));
            message.append("]");
            LOGGER.info(message.toString());
        }
    }

    @AfterReturning(pointcut = "executeLogging()", returning = "returnValue")
    public void logAfterMethodCall(JoinPoint joinPoint, Object returnValue) {
        StringBuilder message = new StringBuilder("method:[");
        message.append(joinPoint.getSignature().getName());
        message.append("], ");
        Object[] args = joinPoint.getArgs();
        if (null != args && args.length > 0) {
            message.append("args:[");
            Arrays.asList(args).forEach(arg -> message.append("arg=").append(arg).append("|"));
        }
        message.append("], ");

        if(returnValue instanceof Collection) {
            message.append("returning:[").append(((Collection) returnValue).size()).append(" instance(s)");
        } else {
            message.append("returning:[").append(returnValue.toString());
        }
        message.append("]");

        LOGGER.info(message.toString());
    }

    @Pointcut("@annotation(AroundLoggable)")
    public void executeAroundLogging() {

    }

    @Around("executeAroundLogging()")
    public Object logAroundMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        long totalTime = System.currentTimeMillis() - startTime;

        StringBuilder message = new StringBuilder("method:[");
        message.append(joinPoint.getSignature().getName()).append("], ");
        message.append("executionTime:[").append(totalTime).append("], ");
        Object[] args = joinPoint.getArgs();
        if (null != args && args.length > 0) {
            message.append("args:[");
            Arrays.asList(args).forEach(arg -> message.append("arg=").append(arg).append("|"));
        }
        message.append("], ");

        if(returnValue instanceof Collection) {
            message.append("returning:[").append(((Collection) returnValue).size()).append(" instance(s)").append("]");
        } else {
            message.append("returning:[").append(returnValue.toString()).append("]");
        }

        LOGGER.info(message.toString());
        return returnValue;
    }
}
