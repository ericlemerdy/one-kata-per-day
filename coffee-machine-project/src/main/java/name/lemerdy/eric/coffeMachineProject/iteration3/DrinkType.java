package name.lemerdy.eric.coffeMachineProject.iteration3;

public enum DrinkType {
    COFFEE("C", 0.6f),
    HOT_CHOCOLATE("H", 0.5f),
    NONE("", 0f),
    ORANGE_JUICE("O", 0.6f),
    TEA("T", 0.4f);

    public final String character;
    public final Float price;

    DrinkType(String character, Float price) {
        this.character = character;
        this.price = price;
    }
}
