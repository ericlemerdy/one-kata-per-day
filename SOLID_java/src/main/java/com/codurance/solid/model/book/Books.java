package com.codurance.solid.model.book;

import java.util.List;

public interface Books {

	void add(Book item);

	List<Book> all();

	double numberOfITBooks();

	double numberOfTravelBooks();

	double totalPriceForITBooks();

	double totalPriceForTravelBooks();

	double totalPriceForOtherBooks();

}
