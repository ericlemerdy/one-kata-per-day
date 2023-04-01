package name.lemerdy.eric.coffeMachineProject.iteration5.domain.model;

import java.math.BigDecimal;
import java.util.Map;

public record CoffeeMachineReport(Map<DrinkType, Integer> drinksSold, BigDecimal balance) {
}
