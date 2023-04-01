package name.lemerdy.eric.coffeMachineProject.iteration4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DrinkMakerProtocolMessageBuilderTest {
    private static Stream<Arguments> orders() {
        return Stream.of(
                Arguments.of(new Order(new Drink(DrinkType.TEA, Temperature.NORMAL, Sugars.ONE), new Money(.4D)), "T:1:0"),
                Arguments.of(new Order(new Drink(DrinkType.HOT_CHOCOLATE, Temperature.NORMAL, Sugars.NONE), new Money(.5D)), "H::"),
                Arguments.of(new Order(new Drink(DrinkType.COFFEE, Temperature.NORMAL, Sugars.TWO), new Money(.6D)), "C:2:0"),
                Arguments.of(new Order(new Message("message-content")), "M:message-content"),
                Arguments.of(new Order(new Drink(DrinkType.TEA, Temperature.NORMAL, Sugars.NONE), Money.NONE), "M:missing-0,40-to-serve-requested-drink"),
                Arguments.of(new Order(new Drink(DrinkType.HOT_CHOCOLATE, Temperature.NORMAL, Sugars.ONE), new Money(.2D)), "M:missing-0,30-to-serve-requested-drink"),
                Arguments.of(new Order(new Drink(DrinkType.ORANGE_JUICE, Temperature.NORMAL, Sugars.NONE), new Money(.6D)), "O::"),
                Arguments.of(new Order(new Drink(DrinkType.COFFEE, Temperature.EXTRA_HOT, Sugars.NONE), new Money(.6D)), "Ch::")
        );
    }

    @ParameterizedTest
    @MethodSource("orders")
    public void shouldTakeOrderToBuildMessageInDrinkMakerProtocol(Order order, String expectedDrinkMakerProtocolMessage) {
        String actualMessage = new DrinkMaker().accept(order);

        Assertions.assertEquals(expectedDrinkMakerProtocolMessage, actualMessage);
    }

    @Test
    public void shouldPrintReport() {
        List<Order> orders = List.of(
                new Order(new Drink(DrinkType.ORANGE_JUICE, Temperature.NORMAL, Sugars.NONE), new Money(2D)),
                new Order(new Drink(DrinkType.COFFEE, Temperature.EXTRA_HOT, Sugars.NONE), new Money(.4D)),
                new Order(new Message("random-content")),
                new Order(new Drink(DrinkType.HOT_CHOCOLATE, Temperature.EXTRA_HOT, Sugars.ONE), Money.NONE),
                new Order(new Drink(DrinkType.TEA, Temperature.EXTRA_HOT, Sugars.TWO), Money.NONE),
                new Order(new Drink(DrinkType.ORANGE_JUICE, Temperature.NORMAL, Sugars.NONE), Money.NONE),
                new Order(new Drink(DrinkType.ORANGE_JUICE, Temperature.NORMAL, Sugars.NONE), new Money(.5D))
        );
        DrinkMaker drinkMaker = new DrinkMaker();
        drinkMaker.accept(orders.stream());
        DrinkMakerReport report = drinkMaker.report();

        Assertions.assertEquals(new DrinkMakerReport(Map.of(DrinkType.TEA, 1, DrinkType.COFFEE, 1, DrinkType.ORANGE_JUICE, 2, DrinkType.HOT_CHOCOLATE, 1), BigDecimal.valueOf(.2D).setScale(2, RoundingMode.HALF_EVEN)), report);
    }
}
