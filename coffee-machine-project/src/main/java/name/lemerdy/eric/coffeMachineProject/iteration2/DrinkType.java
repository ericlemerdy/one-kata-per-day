package name.lemerdy.eric.coffeMachineProject.iteration2;

public enum DrinkType {
    TEA("T", 0.4f), HOT_CHOCOLATE("H", 0.5f), COFFEE("C", 0.6f), NONE("", 0f);

    public final String character;
    public final Float price;

    DrinkType(String character, Float price) {
        this.character = character;
        this.price = price;
    }
}
