package com.dyer.frameworks.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Simple annotation to designate a method that is protected
 * by the Circuit Breaker pattern.
 */
@Target({ ElementType.METHOD  })
@Retention(RetentionPolicy.RUNTIME)
public @interface ProtectedCircuit {
    String failOverMethod();
}
