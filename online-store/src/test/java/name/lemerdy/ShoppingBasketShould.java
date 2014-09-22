package name.lemerdy;

import name.lemerdy.ShoppingBasket;
import name.lemerdy.model.Stock;
import name.lemerdy.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static name.lemerdy.ItemBuilder.oneItem;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingBasketShould {

    @Mock
    Stock stock;

    @Test
    public void user_has_a_shopping_basket_with_a_few_items() {
        Item oneItem = oneItem().build();
        Item anotherItem = oneItem().build();
        ShoppingBasket shoppingBasket = new ShoppingBasket(null, oneItem, anotherItem);

        Iterable<Item> itemsInBasket = shoppingBasket.items();

        assertThat(itemsInBasket).containsOnly(oneItem, anotherItem);
    }

    @Test
    public void with_one_item_not_in_stock_and_another_one_in_stock_all_items_should_not_be_in_stock() {
        Item itemInStock = oneItem().simulateInStock(true).build();
        Item itemNotInStock = oneItem().simulateInStock(false).build();

        ShoppingBasket shoppingBasket = new ShoppingBasket(stock, itemInStock, itemNotInStock);

        assertThat(shoppingBasket.allItemsInStock()).isFalse();
        assertThat(shoppingBasket.itemsNotInStock()).containsOnly(itemNotInStock);
    }

}
