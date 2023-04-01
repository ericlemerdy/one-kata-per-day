package name.lemerdy.eric.coffeMachineProject.iteration4;

import java.math.BigDecimal;

public record Money(BigDecimal amount) {
    public static final Money NONE = new Money(0D);

    public Money(double amount) {
        this(BigDecimal.valueOf(amount));
    }
}
