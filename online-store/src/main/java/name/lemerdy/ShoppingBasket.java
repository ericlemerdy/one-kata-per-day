package name.lemerdy;

import name.lemerdy.model.Item;
import org.assertj.core.util.Sets;

import java.util.Arrays;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;
import static org.assertj.core.util.Sets.newHashSet;

public class ShoppingBasket {
    private Set<Item> items;

    public ShoppingBasket(Item... items) {
        this.items = unmodifiableSet(newHashSet(asList(items)));
    }

    public Iterable<Item> items() {
        return items;
    }
}
