package name.lemerdy;

import name.lemerdy.model.Item;
import name.lemerdy.model.payment.PaymentGateway;
import name.lemerdy.model.payment.PaymentStatus;
import name.lemerdy.model.stock.Stock;

import java.util.OptionalDouble;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;
import static java.util.stream.Collectors.toSet;

public class ShoppingBasket {
    private Set<Item> items;
    private Stock stock;
    private PaymentGateway paymentGateway;
    private EmailNotification emailNotification;

    public ShoppingBasket(Stock stock, PaymentGateway paymentGateway, EmailNotification emailNotification,
            Item... items) {
        this.stock = stock;
        this.paymentGateway = paymentGateway;
        this.emailNotification = emailNotification;
        this.items = unmodifiableSet(newHashSet(asList(items)));
    }

    public Iterable<Item> items() {
        return items;
    }

    public boolean allItemsInStock() {
        return items.stream().allMatch(i -> stock.isItemInStock(i));
    }

    public Set<Item> itemsNotInStock() {
        return items.stream().filter(i -> !stock.isItemInStock(i)).collect(toSet());
    }

    public PaymentStatus pay(String creditCardNumber, String owner, String date) {
        return paymentGateway.send(creditCardNumber, owner, date, basketPrice().getAsDouble());
    }

    public void sendNotification(String userEmail) {
        OptionalDouble reduce = basketPrice();
        emailNotification.sendPaymentConfirmation(userEmail, reduce.getAsDouble());
    }

    private OptionalDouble basketPrice() {
        return items.stream().mapToDouble(i -> i.price()).reduce((p, s) -> p + s);
    }
}
