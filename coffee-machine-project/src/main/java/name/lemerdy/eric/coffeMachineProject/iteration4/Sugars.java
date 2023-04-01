package name.lemerdy.eric.coffeMachineProject.iteration4;

public enum Sugars {
    ONE(1), TWO(2), NONE(0);

    public final Integer numberOfSugar;

    public final String character;

    Sugars(Integer numberOfSugar) {
        this.numberOfSugar = numberOfSugar;
        if (numberOfSugar == 0) {
            this.character = "";
        } else {
            this.character = String.valueOf(numberOfSugar);
        }
    }
}
