package name.lemerdy.eric.onlinestore.model.stock;

import name.lemerdy.eric.onlinestore.model.Item;

public interface Stock {
    boolean isItemInStock(Item item);
}
