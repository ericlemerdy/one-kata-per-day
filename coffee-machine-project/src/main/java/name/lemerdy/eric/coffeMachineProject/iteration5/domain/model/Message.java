package name.lemerdy.eric.coffeMachineProject.iteration5.domain.model;

public record Message(String content) {
    public static final Message NONE = new Message(null);
}
