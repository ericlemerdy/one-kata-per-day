package name.lemerdy;

import name.lemerdy.model.Item;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;

public class ShoppingBasket {
    private Set<Item> items;

    public ShoppingBasket(Item... items) {
        this.items = unmodifiableSet(newHashSet(asList(items)));
    }

    public Iterable<Item> items() {
        return items;
    }
}
