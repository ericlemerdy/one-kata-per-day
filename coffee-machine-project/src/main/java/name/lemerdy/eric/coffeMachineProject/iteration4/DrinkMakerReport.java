package name.lemerdy.eric.coffeMachineProject.iteration4;

import java.math.BigDecimal;
import java.util.Map;

public record DrinkMakerReport(Map<DrinkType, Integer> drinksSold, BigDecimal balance) {
}
