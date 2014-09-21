import name.lemerdy.ItemBuilder;
import name.lemerdy.ShoppingBasket;
import name.lemerdy.Stock;
import name.lemerdy.model.Item;
import org.junit.Test;
import org.mockito.Mockito;

import static name.lemerdy.ItemBuilder.oneItem;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

public class ShoppingBasketShould {

    @Test
    public void user_has_a_shopping_basket_with_a_few_items() throws Exception {
        Item oneItem = oneItem();
        Item anotherItem = oneItem();
        ShoppingBasket shoppingBasket = new ShoppingBasket(oneItem, anotherItem);

        Iterable<Item> itemsInBasket = shoppingBasket.items();

        assertThat(itemsInBasket).containsExactly(oneItem, anotherItem);
    }

    @Test
    public void with_all_items_in_stock_should_check_that() throws Exception {
        Item item = oneItem();

        Stock stock = new Stock();
        doReturn(true).when(stock.isItemInStock(item));
        new ShoppingBasket(item);
    }

}
