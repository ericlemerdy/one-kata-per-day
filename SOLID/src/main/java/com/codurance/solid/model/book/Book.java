package com.codurance.solid.model.book;

import java.util.function.ToDoubleFunction;


public class Book {

	private String name;
	private BookType type;
	private double price;
	public static ToDoubleFunction<? super Book> PRICE_EXTRACTOR = b -> b.price();

	public Book(String name, BookType type, double price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}

    public String name() {
		return name;
	}

    public BookType type() {
		return type;
	}

    public double price() {
		return price;
	}

	public String toString() {
		return "Book{" +
				"name='" + name + '\'' +
				", type='" + type + '\'' +
				", price=" + price +
				'}';
	}
}
