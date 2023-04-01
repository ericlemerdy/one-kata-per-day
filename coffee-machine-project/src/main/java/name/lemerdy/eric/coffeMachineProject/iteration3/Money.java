package name.lemerdy.eric.coffeMachineProject.iteration3;

public record Money(Float amount) {
    public static final Money NONE = new Money(0f);
}
