package name.lemerdy.eric.coffeMachineProject.iteration4;

public record Message(String content) {
    public static final Message NONE = new Message(null);
}
