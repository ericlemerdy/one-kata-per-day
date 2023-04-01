package name.lemerdy.eric.coffeMachineProject.iteration2;

public class DrinkMakerProtocolMessageBuilder {
    public static String take(Order order, Money money) {
        float balance = money.amount() - order.drink().price();
        if (balance < 0) {
            return "M:missing-%s-to-serve-requested-drink".formatted(-balance);
        }

        StringBuilder message = new StringBuilder();
        if (order.hasMessage()) {
            message.append("M:").append(order.message().content());
        } else {
            Drink drink = order.drink();
            message.append(drink.type().character);
            message.append(":");
            message.append(drink.sugars().character);
            message.append(":");
            message.append(drink.stick());
        }
        return message.toString();
    }
}
