package name.lemerdy.model;

import static org.mockito.Mockito.doReturn;
import name.lemerdy.model.Item;
import name.lemerdy.model.stock.Stock;

public class ItemBuilder {

    Item item;
    private String itemName;
    private double price;

    public static ItemBuilder oneItem() {
        return new ItemBuilder();
    }

    public Item build() {
        return new Item() {
            @Override
            public double price() {
                return price;
            }
            @Override
            public String getName() {
                return itemName;
            }
        };
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
    
    public ItemBuilder costing(final double price) {
        this.price = price;
        return this;
    }

    public ItemBuilder named(String itemName) {
        this.itemName = itemName;
        return this;
    }
}
