package com.codurance.solid;

import static com.codurance.builders.BookBuilder.aCookingBook;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.codurance.solid.model.book.Book;

public class BookShould {

	@Test
	public void be_named() throws Exception {
		Book book = aCookingBook().build();

		assertThat(book.name(), is("book name"));
	}
	
	@Test
	public void print_itself() throws Exception {
		Book book = aCookingBook().costing(5.0d).build();

		assertThat(book.toString(), is("Book{name='book name', type='COOKING', price=5.0}"));
	}
}
