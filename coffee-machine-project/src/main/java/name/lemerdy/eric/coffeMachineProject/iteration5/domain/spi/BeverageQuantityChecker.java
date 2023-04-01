package name.lemerdy.eric.coffeMachineProject.iteration5.domain.spi;

import name.lemerdy.eric.coffeMachineProject.iteration5.domain.model.DrinkType;

public interface BeverageQuantityChecker {
    boolean isEmpty(DrinkType drink);
}