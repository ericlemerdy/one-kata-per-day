package com.codurance.solid.model;

import static com.codurance.solid.model.discount.Discounter.priceAfterDiscount;
import static java.lang.Math.round;

import java.util.List;

import com.codurance.solid.infrastructure.book.BookList;
import com.codurance.solid.model.book.Book;
import com.codurance.solid.model.book.BookType;
import com.codurance.solid.model.book.Books;

public class Basket {

	private Books books = new BookList();

	public void add(Book item) {
		books.add(item);
	}

	public List<Book> books() {
		return books.all();
	}

	public double priceWithDiscount() {

		double totalPrice = 0.0;
		for (BookType bookType : BookType.values()) {
			totalPrice += priceAfterDiscount( //
					books.countBy(bookType), //
					books.totalPriceFor(bookType), //
					bookType.discount());
		}
		return toDecimal(totalPrice);

	}

	public double fullPrice() {
		double price = 0;
		for (Book book : books.all()) {
			price += book.price();
		}
		return toDecimal(price);
	}

	private double toDecimal(double number) {
		return round(number * 100) / 100.0;
	}

}
