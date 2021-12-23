package name.lemerdy.eric.onlinestore.snippet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import name.lemerdy.eric.onlinestore.ShoppingBasket;
import name.lemerdy.eric.onlinestore.model.ItemBuilder;
import name.lemerdy.eric.onlinestore.model.stock.Stock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ShoppingBasketPayment {
    private Stock stock = mock(Stock.class);
    private ItemBuilder oneItem;
    private ShoppingBasket shoppingBasket;
    private boolean allItemsInStock;
    
    @Given("user has a shopping basket with an item {string} not in stock")
    public void user_has_a_shopping_basket_with_an_item(String itemName) {
        oneItem = ItemBuilder.oneItem().notIn(stock).named(itemName);
        shoppingBasket = new ShoppingBasket(stock, null, null, oneItem.build());
    }
    
    @When("the user checkout")
    public void the_user_checkout() {
        allItemsInStock = shoppingBasket.allItemsInStock();
    }
    
    @Then("the payment is aborted")
    public void the_payment_is_aborted() {
        assertThat(allItemsInStock).isFalse();
    }
    
    @Then("the user is informed that {String} is out of stock")
    public void the_user_is_informed_that_is_out_of_stock(String itemName) {
        assertThat(shoppingBasket.itemsNotInStock()).extracting("name").containsExactly(itemName);
    }
}

