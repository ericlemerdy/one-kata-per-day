package name.lemerdy.eric.coffeMachineProject.iteration4;

public class Order {

    private final Drink drink;
    private final Message message;
    private final Money money;

    public Order(final Drink drink, Money money) {
        this.drink = drink;
        this.message = Message.NONE;
        this.money = money;
    }

    public Order(final Message message) {
        this.message = message;
        this.drink = Drink.NONE;
        this.money = Money.NONE;
    }

    public Drink drink() {
        return this.drink;
    }

    public Message message() {
        return this.message;
    }

    public Money money() {
        return this.money;
    }

    public boolean hasMessage() {
        return this.message != Message.NONE;
    }

    @Override
    public String toString() {
        return "Order[" +
                "drink=" + drink +
                ", message=" + message +
                ", money=" + money +
                ']';
    }
}