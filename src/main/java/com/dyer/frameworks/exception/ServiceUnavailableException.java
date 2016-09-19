package com.dyer.frameworks.exception;

/**
 * Simple {@link RuntimeException} extension {@code class} to delineate when
 * a service outage occurs.
 */
public class ServiceUnavailableException extends RuntimeException {

    public ServiceUnavailableException(String message) {
        super(message);
    }

    public ServiceUnavailableException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
