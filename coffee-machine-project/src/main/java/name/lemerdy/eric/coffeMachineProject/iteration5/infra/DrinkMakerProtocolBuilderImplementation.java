package name.lemerdy.eric.coffeMachineProject.iteration5.infra;

import name.lemerdy.eric.coffeMachineProject.iteration5.domain.model.*;
import name.lemerdy.eric.coffeMachineProject.iteration5.domain.spi.DrinkMakerProtocolBuilder;

public class DrinkMakerProtocolBuilderImplementation implements DrinkMakerProtocolBuilder {
    @Override
    public String buildMessage(Message message) {
        return "M:%s".formatted(message.content());
    }

    @Override
    public String buildDrink(Drink drink) {
        return "%s%s:%s:%s".formatted(adapt(drink.type()), adapt(drink.temperature()), adapt(drink.sugars()), adapt(drink.hasStick()));
    }

    private String adapt(boolean hasStick) {
        return hasStick ? "0" : "";
    }

    private String adapt(Sugars sugars) {
        if (sugars.numberOfSugar == 0) {
            return "";
        }
        return String.valueOf(sugars.numberOfSugar);
    }

    private String adapt(Temperature temperature) {
        return switch (temperature) {
            case EXTRA_HOT -> "h";
            case NORMAL -> "";
        };
    }

    private String adapt(DrinkType type) {
        return switch (type) {
            case COFFEE -> "C";
            case HOT_CHOCOLATE -> "H";
            case NONE -> "";
            case ORANGE_JUICE -> "O";
            case TEA -> "T";
        };
    }
}
