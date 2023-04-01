package name.lemerdy.eric.coffeMachineProject.iteration2;

public record Drink(DrinkType type, Sugars sugars) {
    public static Drink NONE = new Drink(DrinkType.NONE, Sugars.NONE);

    public String stick() {
        return this.sugars.numberOfSugar > 0 ? "0" : "";
    }

    public Float price() {
        return this.type.price;
    }
}