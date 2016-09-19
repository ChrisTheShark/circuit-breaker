package com.dyer.frameworks.aspects;

import com.dyer.frameworks.annotation.ProtectedCircuit;
import com.dyer.frameworks.exception.TrippedBreakerException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Aspect used to trigger the circuit breaker pattern service
 * delegation in the event of a thrown {@link TrippedBreakerException}.
 */
@Aspect
@Component
public class CircuitBreakerAspect {

    @Pointcut("within(com.dyer.frameworks.service..*)")
    public void inBreakerProtectedLayer() {}

    @Around("inBreakerProtectedLayer()")
    public Object protectCircuit(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnValue = null;
        try {
            returnValue = proceedingJoinPoint.proceed();
        } catch (TrippedBreakerException exception) {
            MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
            ProtectedCircuit annotation = signature.getMethod().getAnnotation(ProtectedCircuit.class);

            Method method = proceedingJoinPoint.getTarget().getClass().getMethod(
                    annotation.failOverMethod(), signature.getParameterTypes());
            returnValue = method.invoke(proceedingJoinPoint.getTarget(),
                    proceedingJoinPoint.getArgs());
        }
        return returnValue;
    }

}
