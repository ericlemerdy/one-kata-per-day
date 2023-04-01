package name.lemerdy.eric.coffeMachineProject.iteration3;

public record Drink(DrinkType type, Temperature temperature, Sugars sugars) {
    public static Drink NONE = new Drink(DrinkType.NONE, Temperature.NORMAL, Sugars.NONE);

    public String stick() {
        return this.sugars.numberOfSugar > 0 ? "0" : "";
    }

    public Float price() {
        return this.type.price;
    }
}