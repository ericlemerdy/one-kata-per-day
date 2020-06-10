package com.codurance.builders;

import static com.codurance.solid.BookType.IT;

import com.codurance.solid.Book;
import com.codurance.solid.BookType;

public class BookBuilder {

	private static final String A_NAME = "book name";
	private BookType bookType;
	private double price;

	public BookBuilder(BookType bookType) {
		this.bookType = bookType;
	}

	public static BookBuilder aCookingBook() {
		return new BookBuilder(BookType.COOKING);
	}

	public static BookBuilder anITBook() {
		return new BookBuilder(IT);
	}
	
	
	public static BookBuilder aTravelBook() {
		return new BookBuilder(BookType.TRAVEL);
	}

	public BookBuilder costing(double price) {
		this.price = price;
		return this;
	}

	public Book build() {
		return new Book(A_NAME, bookType, price);
	}

}
