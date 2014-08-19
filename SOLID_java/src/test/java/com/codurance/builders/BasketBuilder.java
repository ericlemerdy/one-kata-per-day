package com.codurance.builders;

import com.codurance.solid.Basket;
import com.codurance.solid.Book;

public class BasketBuilder {

	private Book[] books = new Book[] {};

	public static BasketBuilder aBasket() {
		return new BasketBuilder();
	}

	public BasketBuilder with(Book... books) {
		this.books = books;
		return this;
	}

	public Basket build() {
		Basket basket = new Basket();
		addBooksTo(basket);
		return basket;
	}

	private void addBooksTo(Basket basket) {
		for (Book book : books) {
			basket.add(book);
		}

	}
}
