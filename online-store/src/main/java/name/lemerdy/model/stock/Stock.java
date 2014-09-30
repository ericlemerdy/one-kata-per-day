package name.lemerdy.model.stock;

import name.lemerdy.model.Item;

public interface Stock {
    boolean isItemInStock(Item item);
}
