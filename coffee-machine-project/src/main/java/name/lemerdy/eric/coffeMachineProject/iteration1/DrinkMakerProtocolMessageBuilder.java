package name.lemerdy.eric.coffeMachineProject.iteration1;

public class DrinkMakerProtocolMessageBuilder {
    public static String take(Order order) {
        StringBuilder message = new StringBuilder();

        if (order.hasMessage()) {
            message.append("M:").append(order.message().content());
        } else {
            Drink drink = order.drink();
            message.append(drink.drinkType().character());
            message.append(":");
            message.append(drink.sugars().sugarChar());
            message.append(":");
            message.append(drink.stick());
        }
        return message.toString();
    }
}
