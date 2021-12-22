package name.lemerdy.eric.Application.Boundaries.Register;

import name.lemerdy.eric.Application.Boundaries.IUseCaseInput;
import name.lemerdy.eric.Domain.Accounts.ValueObjects.PositiveMoney;
import name.lemerdy.eric.Domain.Customers.ValueObjects.SSN;

/**
 * Register Input Message.
 */
public class RegisterInput implements IUseCaseInput {
    /**
     * Initializes a new instance of the {@link RegisterInput} class.
     *
     * @param ssn           SSN.
     * @param initialAmount Positive amount.
     */
    public RegisterInput(SSN ssn, PositiveMoney initialAmount) {
        this.SSN = ssn;
        this.InitialAmount = initialAmount;
    }

    public SSN SSN;

    /**
     * @return The SSN.
     */
    public SSN getSSN() {
        return SSN;
    }

    public PositiveMoney InitialAmount;

    /**
     * @return The Initial Amount.
     */
    public PositiveMoney getInitialAmount() {
        return InitialAmount;
    }
}
