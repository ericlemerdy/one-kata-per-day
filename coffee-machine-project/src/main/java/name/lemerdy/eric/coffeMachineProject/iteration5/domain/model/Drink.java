package name.lemerdy.eric.coffeMachineProject.iteration5.domain.model;

public record Drink(DrinkType type, Temperature temperature, Sugars sugars) {
    public static Drink NONE = new Drink(DrinkType.NONE, Temperature.NORMAL, Sugars.NONE);

    public boolean hasStick() {
        return this.sugars.numberOfSugar > 0;
    }
}