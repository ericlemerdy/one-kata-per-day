package name.lemerdy.eric.Domain.Accounts.ValueObjects;

import name.lemerdy.eric.Domain.DomainException;

/**
 * Money Should Be Positive Exception.
 */
public final class MoneyShouldBePositiveException extends DomainException {
    public MoneyShouldBePositiveException(String message) {
        super(message);
    }
}
