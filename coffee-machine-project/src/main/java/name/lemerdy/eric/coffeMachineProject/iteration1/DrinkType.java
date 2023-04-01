package name.lemerdy.eric.coffeMachineProject.iteration1;

public enum DrinkType {
    TEA("T"), HOT_CHOCOLATE("H"), COFFEE("C"), NONE("");

    private final String character;

    DrinkType(String character) {
        this.character = character;
    }

    public String character() {
        return this.character;
    }
}
