package name.lemerdy.eric.Domain.Customers.ValueObjects;

import name.lemerdy.eric.Domain.DomainException;

public class InvalidSSNException extends DomainException {
    public InvalidSSNException(String message) {
        super(message);
    }
}
