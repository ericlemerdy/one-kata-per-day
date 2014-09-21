package com.codurance.solid.model;

import com.codurance.solid.model.book.BookType;
import com.codurance.solid.model.book.Books;
import com.codurance.solid.model.discount.Discounter;

import static com.codurance.solid.model.Basket.toDecimal;

public class DiscountCalculator {
    public double priceWithDiscount(Books books) {
        double totalPrice = 0.0;
        for (BookType bookType : BookType.values()) {
            totalPrice += Discounter.priceAfterDiscount( //
                    books.countBy(bookType), //
                    books.totalPriceFor(bookType), //
                    bookType.discount());
        }
        return toDecimal(totalPrice);
    }
}