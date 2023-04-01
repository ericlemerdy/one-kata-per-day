package name.lemerdy.eric.coffeMachineProject.iteration5.domain.model;

import java.math.BigDecimal;

public enum DrinkType {
    COFFEE(.6D),
    HOT_CHOCOLATE(.5D),
    NONE(0D),
    ORANGE_JUICE(.6D),
    TEA(.4D);

    public final BigDecimal price;

    DrinkType(double price) {
        this.price = BigDecimal.valueOf(price);
    }
}
