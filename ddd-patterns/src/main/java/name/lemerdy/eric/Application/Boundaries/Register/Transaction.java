package name.lemerdy.eric.Application.Boundaries.Register;

import name.lemerdy.eric.Domain.Accounts.ValueObjects.PositiveMoney;

import java.time.LocalDateTime;

/**
 * Transaction.
 */
public final class Transaction {
    /**
     * Initializes a new instance of the {@link Transaction} class.
     *
     * @param description     Text description.
     * @param amount          Positive amount.
     * @param transactionDate Transaction date.
     */
    public Transaction(
            String description,
            PositiveMoney amount,
            LocalDateTime transactionDate) {
        this.Description = description;
        this.Amount = amount;
        this.TransactionDate = transactionDate;
    }

    private String Description;

    /**
     * @return The text description.
     */
    public String getDescription() {
        return Description;
    }

    private PositiveMoney Amount;

    /**
     * @return The Amount.
     */
    public PositiveMoney getAmount() {
        return Amount;
    }

    public LocalDateTime TransactionDate;

    /**
     * @return The transaction date.
     */
    public LocalDateTime getTransactionDate() {
        return TransactionDate;
    }
}
