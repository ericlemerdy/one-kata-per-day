package name.lemerdy.eric.coffeMachineProject.iteration1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DrinkMakerProtocolMessageBuilderTest {
    private static Stream<Arguments> orders() {
        return Stream.of(
                Arguments.of(new Order(new Drink(DrinkType.TEA, Sugars.ONE)), "T:1:0"),
                Arguments.of(new Order(new Drink(DrinkType.HOT_CHOCOLATE, Sugars.NONE)), "H::"),
                Arguments.of(new Order(new Drink(DrinkType.COFFEE, Sugars.TWO)), "C:2:0"),
                Arguments.of(new Order(new Message("message-content")), "M:message-content")
        );
    }

    @ParameterizedTest
    @MethodSource("orders")
    public void shouldTakeOrderToBuildMessageInDrinkMakerProtocol(Order order, String expectedDrinkMakerProtocolMessage) {
        String actualMessage = DrinkMakerProtocolMessageBuilder.take(order);

        Assertions.assertEquals(expectedDrinkMakerProtocolMessage, actualMessage);
    }
}
