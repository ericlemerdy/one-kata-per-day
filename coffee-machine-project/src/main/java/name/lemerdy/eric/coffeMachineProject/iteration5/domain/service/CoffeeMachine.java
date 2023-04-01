package name.lemerdy.eric.coffeMachineProject.iteration5.domain.service;

import name.lemerdy.eric.coffeMachineProject.iteration5.domain.model.*;
import name.lemerdy.eric.coffeMachineProject.iteration5.domain.spi.BeverageQuantityChecker;
import name.lemerdy.eric.coffeMachineProject.iteration5.domain.spi.DrinkMakerProtocolBuilder;
import name.lemerdy.eric.coffeMachineProject.iteration5.domain.spi.EmailNotifier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CoffeeMachine {

    private final BeverageQuantityChecker beverageQuantityChecker;
    private final DrinkMakerProtocolBuilder drinkMakerProtocolBuilder;
    private final Map<DrinkType, Integer> drinksSold;
    private final EmailNotifier emailNotifier;
    private BigDecimal balance;

    public CoffeeMachine(BeverageQuantityChecker beverageQuantityChecker, DrinkMakerProtocolBuilder drinkMakerProtocolBuilder, EmailNotifier emailNotifier) {
        this.balance = BigDecimal.valueOf(0D);
        this.beverageQuantityChecker = beverageQuantityChecker;
        this.drinkMakerProtocolBuilder = drinkMakerProtocolBuilder;
        this.drinksSold = new HashMap<>();
        this.emailNotifier = emailNotifier;
    }

    public void accept(Stream<Order> orders) {
        orders.forEach(CoffeeMachine.this::accept);
    }

    public String accept(Order order) {
        if (order.hasMessage()) {
            return drinkMakerProtocolBuilder.buildMessage(order.message());
        }
        Drink drink = order.drink();
        BigDecimal balance = this.balance.add(order.money().amount()).subtract(drink.type().price).setScale(2, RoundingMode.HALF_EVEN);
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            return drinkMakerProtocolBuilder.buildMessage(new Message("missing-%.2f-to-serve-requested-drink".formatted(balance.negate())));
        }
        if (this.beverageQuantityChecker.isEmpty(drink.type())) {
            this.emailNotifier.notifyMissingDrink(drink.type());
            return drinkMakerProtocolBuilder.buildMessage(new Message("shortage-of-beverage-a-notification-has-been-sent-for-refill"));
        }
        this.drinksSold.merge(drink.type(), 1, Integer::sum);
        this.balance = balance;
        return drinkMakerProtocolBuilder.buildDrink(drink);
    }

    public CoffeeMachineReport report() {
        return new CoffeeMachineReport(drinksSold, balance);
    }

}
