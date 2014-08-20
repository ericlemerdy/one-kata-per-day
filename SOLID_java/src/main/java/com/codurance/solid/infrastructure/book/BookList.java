package com.codurance.solid.infrastructure.book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.codurance.solid.model.book.Book;
import com.codurance.solid.model.book.BookType;
import com.codurance.solid.model.book.Books;
import com.google.common.collect.ImmutableList;

public class BookList implements Books {
	private List<Book> books = new ArrayList<Book>();
	
	@Override
	public void add(Book item) {
		this.books.add(item);
	}

	@Override
	public List<Book> all() {
		return ImmutableList.copyOf(books);
	}

	private Stream<Book> by(BookType bookType) {
		return books.stream().filter(b -> bookType.equals(b.type()));
	}

	@Override
	public long countBy(BookType bookType) {
		return by(bookType).count();
	}

	@Override
	public double totalPriceFor(BookType bookType) {
		return by(bookType).mapToDouble(Book.PRICE_EXTRACTOR).sum();
	}


}
