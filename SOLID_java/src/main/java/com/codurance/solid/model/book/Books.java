package com.codurance.solid.model.book;

import java.util.List;

public interface Books {

	void add(Book item);

	List<Book> all();

	double totalPriceFor(BookType bookType);

	long countBy(BookType bookType);
	
}
