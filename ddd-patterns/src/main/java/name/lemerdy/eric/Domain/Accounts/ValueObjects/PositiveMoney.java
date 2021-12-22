package name.lemerdy.eric.Domain.Accounts.ValueObjects;

/**
 * PositiveMoney <see href="https://github.com/ivanpaulovich/clean-architecture-manga/wiki/Domain-Driven-Design-Patterns#entity">Entity Design Pattern</see>.
 */
public final class PositiveMoney {
    private final Money _value;

    /**
     * Initializes a new instance of the {@link PositiveMoney} struct.
     *
     * @param value Decimal amount.
     */
    public PositiveMoney(double value) throws MoneyShouldBePositiveException {
        if (value < 0) {
            throw new MoneyShouldBePositiveException("The 'Amount' should be positive.");
        }

        this._value = new Money(value);
    }

    /**
     * Converts into Money Value Object.
     *
     * @return Money.
     */
    public Money ToMoney() {
        return this._value;
    }

    private PositiveMoney Add(PositiveMoney positiveAmount) throws MoneyShouldBePositiveException {
        return this._value.Add(positiveAmount._value);
    }

    private Money Subtract(PositiveMoney positiveAmount) {
        return this._value.Subtract(positiveAmount._value);
    }
}
