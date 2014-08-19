package com.codurance.solid;

public class Book {

	private String name;
	private BookType type;
	private double price;

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

	@Override
	public String toString() {
		return "Book{" +
				"name='" + name + '\'' +
				", type='" + type + '\'' +
				", price=" + price +
				'}';
	}
}
