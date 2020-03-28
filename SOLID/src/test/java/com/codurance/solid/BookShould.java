package com.codurance.solid;

import com.codurance.solid.model.book.Book;
import org.junit.Test;

import static com.codurance.builders.BookBuilder.aCookingBook;
import static org.junit.Assert.assertEquals;

public class BookShould {

	@Test
	public void be_named() {
		Book book = aCookingBook().build();

		assertEquals(book.name(), "book name");
	}
	
	@Test
	public void print_itself() {
		Book book = aCookingBook().costing(5.0d).build();

		assertEquals(book.toString(), "Book{name='book name', type='COOKING', price=5.0}");
	}
}
