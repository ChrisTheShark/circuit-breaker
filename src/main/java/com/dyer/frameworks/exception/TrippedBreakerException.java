package com.dyer.frameworks.exception;

/**
 * Simple {@link RuntimeException} extension {@code class}.
 */
public class TrippedBreakerException extends RuntimeException {

    public TrippedBreakerException(String message) {
        super(message);
    }

    public TrippedBreakerException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
