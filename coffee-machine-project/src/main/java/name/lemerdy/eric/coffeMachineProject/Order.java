package name.lemerdy.eric.coffeMachineProject;

public class Order {

    private final Drink drink;
    private final Message message;

    public Order(final Drink drink) {
        this.drink = drink;
        this.message = Message.NONE;
    }

    public Order(final Message message) {
        this.message = message;
        this.drink = Drink.NONE;
    }

    public Drink drink() {
        return this.drink;
    }

    public Message message() {
        return this.message;
    }

    public boolean hasMessage() {
        return this.message != Message.NONE;
    }

}