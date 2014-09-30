package name.lemerdy.model;

import static org.mockito.Mockito.doReturn;
import name.lemerdy.model.Item;
import name.lemerdy.model.stock.Stock;

public class ItemBuilder {

    Item item;

    public static ItemBuilder oneItem() {
        return new ItemBuilder();
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
    
    public ItemBuilder costing(final double price) {
        item = new Item() {
            
            @Override
            public double price() {
                return price;
            }
        };
        return this;
    }
}
