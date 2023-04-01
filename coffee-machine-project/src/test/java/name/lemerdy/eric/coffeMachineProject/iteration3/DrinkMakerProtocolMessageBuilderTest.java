package name.lemerdy.eric.coffeMachineProject.iteration3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DrinkMakerProtocolMessageBuilderTest {
    private static Stream<Arguments> orders() {
        return Stream.of(
                Arguments.of(new Order(new Drink(DrinkType.TEA, Temperature.NORMAL, Sugars.ONE)), new Money(0.4f), "T:1:0"),
                Arguments.of(new Order(new Drink(DrinkType.HOT_CHOCOLATE, Temperature.NORMAL, Sugars.NONE)), new Money(0.5f), "H::"),
                Arguments.of(new Order(new Drink(DrinkType.COFFEE, Temperature.NORMAL, Sugars.TWO)), new Money(0.6f), "C:2:0"),
                Arguments.of(new Order(new Message("message-content")), Money.NONE, "M:message-content"),
                Arguments.of(new Order(new Drink(DrinkType.TEA, Temperature.NORMAL, Sugars.NONE)), Money.NONE, "M:missing-0.4-to-serve-requested-drink"),
                Arguments.of(new Order(new Drink(DrinkType.HOT_CHOCOLATE, Temperature.NORMAL, Sugars.ONE)), new Money(0.2f), "M:missing-0.3-to-serve-requested-drink"),
                Arguments.of(new Order(new Drink(DrinkType.ORANGE_JUICE, Temperature.NORMAL, Sugars.NONE)), new Money(0.6f), "O::"),
                Arguments.of(new Order(new Drink(DrinkType.COFFEE, Temperature.EXTRA_HOT, Sugars.NONE)), new Money(0.6f), "Ch::")
        );
    }

    @ParameterizedTest
    @MethodSource("orders")
    public void shouldTakeOrderToBuildMessageInDrinkMakerProtocol(Order order, Money money, String expectedDrinkMakerProtocolMessage) {
        String actualMessage = DrinkMakerProtocolMessageBuilder.take(order, money);

        Assertions.assertEquals(expectedDrinkMakerProtocolMessage, actualMessage);
    }
}
