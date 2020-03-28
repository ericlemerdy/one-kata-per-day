package com.codurance.solid;

import static com.codurance.builders.BasketBuilder.aBasket;
import static com.codurance.builders.BookBuilder.aCookingBook;
import static com.codurance.builders.BookBuilder.aFantasyBook;
import static com.codurance.builders.BookBuilder.aTravelBook;
import static com.codurance.builders.BookBuilder.anITBook;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.codurance.solid.model.Basket;
import com.codurance.solid.model.book.Book;

public class BasketShould {

	@Test
	public void return_total_price_of_zero_when_empty() {
		assertEquals(emptyBasket().fullPrice(), 0.0d, 0d);
	}

	@Test
	public void return_zero_discount_when_empty() {
		assertEquals(emptyBasket().priceWithDiscount(), 0.0d, 0d);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void return_an_unmodifiable_list_of_books() {
		aBasket().build().books().add(aCookingBook().build());
	}

	@Test
	public void give_no_discount_when_book_is_not_eligible_for_a_discount() {
		Book aBookWithNoDiscount = aCookingBook().costing(10.00).build();
		Basket basket = aBasket().with(aBookWithNoDiscount).build();

		assertEquals(basket.priceWithDiscount(), 10.0d, 0d);
		assertEquals(basket.fullPrice(), 10.0d, 0d);
	}

	@Test
	public void calculate_the_total_price_with_no_discount_when_containing_multiple_books() {
		Basket basket = aBasket().with(aCookingBook().costing(10.0).build(),
				anITBook().costing(30.0).build(),
				anITBook().costing(20.0).build(),
				aTravelBook().costing(20.0).build()).build();

		assertEquals(basket.fullPrice(), 80.0d, 0d);
	}

    @Test
    public void give_30_percent_discount_for_IT_books_when_containing_more_than_two_of_them() {
        Basket basket = aBasket().with(anITBook().costing(30.0).build(),
                anITBook().costing(10.0).build(),
                anITBook().costing(20.0).build()).build();

        assertEquals(basket.priceWithDiscount(), 42.0d, 0d);
    }

	@Test
	public void give_10_percent_discount_for_IT_books_when_containing_on_of_them() {
		Basket basket = aBasket().with(anITBook().costing(10.0).build())
				.build();

		assertEquals(basket.priceWithDiscount(), 9.0d, 0d);
	}

	@Test
	public void give_10_percent_discount_for_IT_books_when_containing_two_of_them() {
		Basket basket = aBasket().with(anITBook().costing(30.0).build(),
				anITBook().costing(10.0).build()).build();

		assertEquals(basket.priceWithDiscount(), 36.0d, 0d);
	}

	@Test
	public void not_give_discounts_for_Travel_books_when_containing_less_than_four_of_them() {
		Basket basket = aBasket().with(aTravelBook().costing(30.0).build(),
				aTravelBook().costing(10.0).build(),
				aTravelBook().costing(20.0).build()).build();

		assertEquals(basket.priceWithDiscount(), 60.0d, 0d);
	}

	@Test
	public void give_40_percent_discount_for_Travel_books_when_containing_more_than_three_of_them() {
		Basket basket = aBasket().with(aTravelBook().costing(30.0).build(),
				aTravelBook().costing(10.0).build(),
				aTravelBook().costing(20.0).build(),
				aTravelBook().costing(10.0).build()).build();

		assertEquals(basket.priceWithDiscount(), 42.0d, 0d);
	}

	@Test
	public void combine_10_percent_discount_for_1_IT_book_and_40_percent_discount_for_4_Travel_books() {
		Basket basket = aBasket().with(anITBook().costing(10.0).build(),
				aTravelBook().costing(30.0).build(),
				aTravelBook().costing(10.0).build(),
				aTravelBook().costing(20.0).build(),
				aTravelBook().costing(10.0).build()).build();

		assertEquals(basket.priceWithDiscount(), 51.0d, 0d);
	}

    @Test
    public void give_20_percent_discount_per_Fantasy_book_for_2_Fantasy_book() throws Exception {
        Basket basket = aBasket().with(aFantasyBook().costing(15.0).build(),
                aFantasyBook().costing(5.0).build()).build();

        assertEquals(basket.priceWithDiscount(), 16.0d, 0d);
    }

    private Basket emptyBasket() {
		return new Basket();
	}

}
