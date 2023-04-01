package name.lemerdy.eric.coffeMachineProject.iteration5.domain.spi;

import name.lemerdy.eric.coffeMachineProject.iteration5.domain.model.DrinkType;

public interface EmailNotifier {
    void notifyMissingDrink(DrinkType drink);
}