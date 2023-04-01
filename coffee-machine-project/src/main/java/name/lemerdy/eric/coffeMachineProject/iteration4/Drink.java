package name.lemerdy.eric.coffeMachineProject.iteration4;

import java.math.BigDecimal;

public record Drink(DrinkType type, Temperature temperature, Sugars sugars) {
    public static Drink NONE = new Drink(DrinkType.NONE, Temperature.NORMAL, Sugars.NONE);

    public String stick() {
        return this.sugars.numberOfSugar > 0 ? "0" : "";
    }

    public BigDecimal price() {
        return this.type.price;
    }
}