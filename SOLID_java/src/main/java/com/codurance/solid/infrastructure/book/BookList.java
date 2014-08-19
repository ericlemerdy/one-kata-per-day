package com.codurance.solid.infrastructure.book;

import static com.codurance.solid.model.book.BookType.IT;
import static com.codurance.solid.model.book.BookType.TRAVEL;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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

	private Stream<Book> by(Predicate<? super Book> bookFilter) {
		return books.stream().filter(bookFilter);
	}

	private Stream<Book> by(BookType bookType) {
		return by(b -> bookType.equals(b.type()));
	}

	private long countBy(BookType bookType) {
		return by(bookType).count();
	}

	private double sumOfPriceBy(Predicate<? super Book> predicate) {
		return by(predicate).mapToDouble(Book.PRICE_EXTRACTOR).sum();
	}

	private double sumOfPriceBy(BookType bookType) {
		return by(bookType).mapToDouble(Book.PRICE_EXTRACTOR).sum();
	}

	@Override
	public double numberOfITBooks() {
		return countBy(IT);
	}

	@Override
	public double numberOfTravelBooks() {
		return countBy(TRAVEL);
	}

	@Override
	public double totalPriceForITBooks() {
		return sumOfPriceBy(IT);
	}

	@Override
	public double totalPriceForTravelBooks() {
		return sumOfPriceBy(TRAVEL);
	}

	@Override
	public double totalPriceForOtherBooks() {
		return sumOfPriceBy(b -> !(IT.equals(b.type()) || TRAVEL.equals(b
				.type())));
	}

}
