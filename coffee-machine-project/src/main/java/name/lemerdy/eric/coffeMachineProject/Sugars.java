package name.lemerdy.eric.coffeMachineProject;

public enum Sugars {
    ONE(1), TWO(2), NONE(0);

    private final Integer numberOfSugar;

    Sugars(Integer numberOfSugar) {
        this.numberOfSugar = numberOfSugar;
    }

    public Integer numberOfSugar() {
        return numberOfSugar;
    }

    public String sugarChar() {
        if (this == NONE) {
            return "";
        }
        return String.valueOf(numberOfSugar);
    }
}
