package name.lemerdy.eric.coffeMachineProject.iteration5;

import name.lemerdy.eric.coffeMachineProject.iteration5.domain.model.*;
import name.lemerdy.eric.coffeMachineProject.iteration5.domain.service.CoffeeMachine;
import name.lemerdy.eric.coffeMachineProject.iteration5.domain.spi.BeverageQuantityChecker;
import name.lemerdy.eric.coffeMachineProject.iteration5.domain.spi.DrinkMakerProtocolBuilder;
import name.lemerdy.eric.coffeMachineProject.iteration5.domain.spi.EmailNotifier;
import name.lemerdy.eric.coffeMachineProject.iteration5.infra.DrinkMakerProtocolBuilderImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class CoffeeMachineTest {

    @Mock
    private BeverageQuantityChecker beverageQuantityChecker;
    @InjectMocks
    private CoffeeMachine coffeeMachine;
    @Spy
    private DrinkMakerProtocolBuilder drinkMakerProtocolBuilder = new DrinkMakerProtocolBuilderImplementation();
    @Mock
    private EmailNotifier emailNotifier;

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
        String actualMessage = coffeeMachine.accept(order);

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
        coffeeMachine.accept(orders.stream());
        CoffeeMachineReport report = coffeeMachine.report();

        Assertions.assertEquals(new CoffeeMachineReport(Map.of(DrinkType.TEA, 1, DrinkType.COFFEE, 1, DrinkType.ORANGE_JUICE, 2, DrinkType.HOT_CHOCOLATE, 1), BigDecimal.valueOf(.2D).setScale(2, RoundingMode.HALF_EVEN)), report);
    }

    @Test
    public void beverageShortage() {
        BDDMockito.when(beverageQuantityChecker.isEmpty(DrinkType.ORANGE_JUICE)).thenReturn(true);
        Order order = new Order(new Drink(DrinkType.ORANGE_JUICE, Temperature.NORMAL, Sugars.NONE), new Money(2D));
        String protocolMessage = coffeeMachine.accept(order);

        Assertions.assertEquals("M:shortage-of-beverage-a-notification-has-been-sent-for-refill", protocolMessage);
        BDDMockito.verify(emailNotifier).notifyMissingDrink(DrinkType.ORANGE_JUICE);
    }
}
