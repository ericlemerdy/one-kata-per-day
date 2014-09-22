package name.lemerdy;

import name.lemerdy.model.Item;
import name.lemerdy.model.Stock;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;
import static java.util.stream.Collectors.toSet;

public class ShoppingBasket {
    private Set<Item> items;
    private Stock stock;

    public ShoppingBasket(Stock stock, Item... items) {
        this.items = unmodifiableSet(newHashSet(asList(items)));
        this.stock = stock;
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
}
