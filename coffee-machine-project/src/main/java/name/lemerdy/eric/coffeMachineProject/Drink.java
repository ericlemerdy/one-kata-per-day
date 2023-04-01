package name.lemerdy.eric.coffeMachineProject;

public record Drink(DrinkType drinkType, Sugars sugars) {
    public static Drink NONE = new Drink(DrinkType.NONE, Sugars.NONE);

    public String stick() {
        return this.sugars.numberOfSugar() > 0 ? "0" : "";
    }
}