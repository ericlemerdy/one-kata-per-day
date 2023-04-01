package name.lemerdy.eric.coffeMachineProject.iteration4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DrinkMaker {
    private final Map<DrinkType, Integer> drinksSold = new HashMap<>();
    private BigDecimal balance = BigDecimal.valueOf(0D);

    public void accept(Stream<Order> orders) {
        orders.forEach(DrinkMaker.this::accept);
    }

    public String accept(Order order) {
        if (order.hasMessage()) {
            return "M:%s".formatted(order.message().content());
        }
        Drink drink = order.drink();
        BigDecimal balance = this.balance.add(order.money().amount()).subtract(drink.price()).setScale(2, RoundingMode.HALF_EVEN);
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            return "M:missing-%.2f-to-serve-requested-drink".formatted(balance.negate());
        }
        this.drinksSold.merge(drink.type(), 1, Integer::sum);
        this.balance = balance;
        return "%s%s:%s:%s".formatted(drink.type().character, drink.temperature().character, drink.sugars().character, drink.stick());
    }

    public DrinkMakerReport report() {
        return new DrinkMakerReport(drinksSold, balance);
    }

}
