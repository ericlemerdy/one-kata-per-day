package name.lemerdy;

import name.lemerdy.model.Item;
import name.lemerdy.model.Stock;

import java.util.stream.IntStream;

import static org.mockito.Mockito.doReturn;

public class ItemBuilder {

    Item item;

    public static ItemBuilder oneItem() {
        ItemBuilder itemBuilder = new ItemBuilder();
        itemBuilder.item = new Item() {
        };
        return itemBuilder;
    }

    public Item build() {
        return item;
    }

    private ItemBuilder simulateInStock(boolean isInStock, Stock stock) {
        doReturn(isInStock).when(stock).isItemInStock(item);
        return this;
    }

    public ItemBuilder in(Stock stock) {
        return simulateInStock(true, stock);
    }

    public ItemBuilder notIn(Stock stock) {
        return simulateInStock(false, stock);
    }
}
