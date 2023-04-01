package name.lemerdy.eric.coffeMachineProject.iteration5.domain.model;

public record Order(Drink drink, Message message, Money money) {

    public Order(final Drink drink, final Money money) {
        this(drink, Message.NONE, money);
    }

    public Order(final Message message) {
        this(Drink.NONE, message, Money.NONE);
    }

    public boolean hasMessage() {
        return this.message != Message.NONE;
    }
}