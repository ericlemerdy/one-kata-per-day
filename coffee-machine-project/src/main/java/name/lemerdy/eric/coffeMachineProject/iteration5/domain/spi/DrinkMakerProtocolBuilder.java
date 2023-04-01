package name.lemerdy.eric.coffeMachineProject.iteration5.domain.spi;

import name.lemerdy.eric.coffeMachineProject.iteration5.domain.model.Drink;
import name.lemerdy.eric.coffeMachineProject.iteration5.domain.model.Message;

public interface DrinkMakerProtocolBuilder {
    String buildMessage(Message message);

    String buildDrink(Drink drink);
}
