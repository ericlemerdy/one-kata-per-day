package name.lemerdy.eric.Domain.Accounts.ValueObjects;

/**
 * Money <a href="https://github.com/ivanpaulovich/clean-architecture-manga/wiki/Domain-Driven-Design-Patterns#entity">Entity Design Pattern</a>.
 */
public final class Money {
    private final double _money;

    /**
     * Initializes a new instance of the {@link Money} class.
     *
     * @param value Decimal amount.
     */
    public Money(double value) {
        this._money = value;
    }

    /**
     * Converts into decimal.
     *
     * @return decimal amount.
     */
    public double ToDecimal() {
        return this._money;
    }

    private boolean LessThan(PositiveMoney amount) {
        return this._money < amount.ToMoney()._money;
    }

    private boolean IsZero() {
        return this._money == 0;
    }

    PositiveMoney Add(Money value) {
        return new PositiveMoney(this._money + value.ToDecimal());
    }

    Money Subtract(Money value) {
        return new Money(this._money - value.ToDecimal());
    }
}
