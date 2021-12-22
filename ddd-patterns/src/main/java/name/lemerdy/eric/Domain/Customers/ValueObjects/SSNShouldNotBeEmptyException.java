package name.lemerdy.eric.Domain.Customers.ValueObjects;

import name.lemerdy.eric.Domain.DomainException;

/**
 * SSN Should Not Be Empty Exception.
 */
public final class SSNShouldNotBeEmptyException extends DomainException {
    public SSNShouldNotBeEmptyException(String message) {
        super(message);
    }
}
