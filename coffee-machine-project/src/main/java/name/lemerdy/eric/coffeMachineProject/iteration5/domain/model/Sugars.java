package name.lemerdy.eric.coffeMachineProject.iteration5.domain.model;

public enum Sugars {
    ONE(1), TWO(2), NONE(0);

    public final Integer numberOfSugar;

    Sugars(Integer numberOfSugar) {
        this.numberOfSugar = numberOfSugar;
    }
}
