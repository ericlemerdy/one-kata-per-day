package name.lemerdy.eric.solid.model;

import name.lemerdy.eric.solid.model.book.BookType;
import name.lemerdy.eric.solid.model.book.Books;
import name.lemerdy.eric.solid.model.discount.Discounter;

import static name.lemerdy.eric.solid.model.Basket.toDecimal;

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