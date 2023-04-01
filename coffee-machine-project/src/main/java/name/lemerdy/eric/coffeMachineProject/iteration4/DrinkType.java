package name.lemerdy.eric.coffeMachineProject.iteration4;

import java.math.BigDecimal;

public enum DrinkType {
    COFFEE("C", .6D),
    HOT_CHOCOLATE("H", .5D),
    NONE("", 0D),
    ORANGE_JUICE("O", .6D),
    TEA("T", .4D);

    public final String character;
    public final BigDecimal price;

    DrinkType(String character, double price) {
        this.character = character;
        this.price = BigDecimal.valueOf(price);
    }
}
