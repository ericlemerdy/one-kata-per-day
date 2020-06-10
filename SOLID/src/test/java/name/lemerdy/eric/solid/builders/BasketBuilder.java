package name.lemerdy.eric.solid.builders;

import name.lemerdy.eric.solid.model.Basket;
import name.lemerdy.eric.solid.model.book.Book;

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
