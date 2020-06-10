package name.lemerdy.eric.solid.model;

import static java.lang.Math.round;

import java.util.List;

import name.lemerdy.eric.solid.infrastructure.book.BookList;
import name.lemerdy.eric.solid.model.book.Book;
import name.lemerdy.eric.solid.model.book.Books;

public class Basket {

    private final DiscountCalculator discountCalculator = new DiscountCalculator();
    private Books books = new BookList();

	public void add(Book item) {
		books.add(item);
	}

	public List<Book> books() {
		return books.all();
	}

	public double priceWithDiscount() {
        return discountCalculator.priceWithDiscount(books);
    }

	public double fullPrice() {
		double price = 0;
		for (Book book : books.all()) {
			price += book.price();
		}
		return toDecimal(price);
	}

	protected static double toDecimal(double number) {
		return round(number * 100) / 100.0;
	}

}
