package name.lemerdy;

import static name.lemerdy.ItemBuilder.oneItem;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import name.lemerdy.model.Item;
import name.lemerdy.model.payment.PaymentFailure;
import name.lemerdy.model.payment.PaymentGateway;
import name.lemerdy.model.payment.PaymentStatus;
import name.lemerdy.model.stock.Stock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingBasketShould {

    @Mock
    Stock stock;

    @Mock
    PaymentGateway paymentGateway;

    @Test
    public void user_has_a_shopping_basket_with_a_few_items() {
        Item oneItem = oneItem().build();
        Item anotherItem = oneItem().build();
        ShoppingBasket shoppingBasket = new ShoppingBasket(null, null, oneItem, anotherItem);

        Iterable<Item> itemsInBasket = shoppingBasket.items();

        assertThat(itemsInBasket).containsOnly(oneItem, anotherItem);
    }

    @Test
    public void with_one_item_not_in_stock_and_another_one_in_stock_all_items_should_not_be_in_stock() {
        Item itemInStock = oneItem().in(stock).build();
        Item itemNotInStock = oneItem().notIn(stock).build();

        ShoppingBasket shoppingBasket = new ShoppingBasket(stock, null, itemInStock, itemNotInStock);

        assertThat(shoppingBasket.allItemsInStock()).isFalse();
        assertThat(shoppingBasket.itemsNotInStock()).containsOnly(itemNotInStock);
    }

    @Test
    public void payment_is_sent_to_the_payment_gateway_external_system_with_success() {
        Item itemInStock = oneItem().in(stock).build();
        String creditCardNumber = "4242 4242 4242 4242";
        String owner = "MR FOO BAR";
        String date = "0114";
        doReturn(new PaymentSuccessful()).when(paymentGateway).send(creditCardNumber, owner, date);

        PaymentStatus paymentStatus = new ShoppingBasket(stock, paymentGateway, itemInStock).pay(creditCardNumber,
                owner, date);

        assertThat(paymentStatus).isInstanceOf(PaymentSuccessful.class);
    }

    @Test
    public void payment_is_sent_to_the_payment_gateway_external_system_with_failure() {
        Item itemInStock = oneItem().in(stock).build();
        String creditCardNumber = "4242 4242 4242 4242";
        String owner = "MR FOO BAR";
        String date = "0114";
        doReturn(new PaymentFailure("User failed credit check")).when(paymentGateway).send(creditCardNumber, owner,
                date);

        PaymentStatus paymentStatus = new ShoppingBasket(stock, paymentGateway, itemInStock).pay(creditCardNumber,
                owner, date);

        assertThat(paymentStatus).isInstanceOf(PaymentFailure.class);
        assertThat(paymentStatus.message()).isEqualTo("User failed credit check");
    }
}