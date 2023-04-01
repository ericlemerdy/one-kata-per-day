package name.lemerdy.eric.coffeMachineProject;

public record Message(String content) {
    public static final Message NONE = new Message(null);
}
