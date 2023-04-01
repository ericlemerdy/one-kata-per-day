package name.lemerdy.eric.coffeMachineProject.iteration5.domain.model;

import java.math.BigDecimal;

public record Money(BigDecimal amount) {
    public static final Money NONE = new Money(0D);

    public Money(double amount) {
        this(BigDecimal.valueOf(amount));
    }
}
