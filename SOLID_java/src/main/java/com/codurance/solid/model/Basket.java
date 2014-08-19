package com.codurance.solid.model;

import static java.lang.Math.round;

import java.util.List;

import com.codurance.solid.infrastructure.book.BookList;
import com.codurance.solid.model.book.Book;
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
		double it_books_discount = 0;
		double travel_books_discount = 0;
		double number_of_it_books = books.numberOfITBooks();
		double number_of_travel_books = books.numberOfTravelBooks();
		double total_price_for_it_books = books.totalPriceForITBooks();
		double total_price_for_travel_books = books.totalPriceForTravelBooks();
		double total_price_for_other_books = books.totalPriceForOtherBooks();

		if (number_of_it_books > 2) {
			it_books_discount = 0.7; // 30% discount when buying more than 2 IT books
		} else if (number_of_it_books > 0) {
			it_books_discount = 0.9; // 10% discount when buying up to 2 IT books
		}
		if (number_of_travel_books > 3) {
			travel_books_discount = 0.6; // 40% discount when buying more than 3 travel books
		}

		if (travel_books_discount > 0) {
			total_price_for_travel_books *= travel_books_discount;
		}

		return toDecimal((
				  total_price_for_it_books * it_books_discount)
				+ total_price_for_travel_books
				+ total_price_for_other_books);

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
