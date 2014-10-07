package com.codurance.solid.model.book;

import static java.lang.Double.MAX_VALUE;

import java.util.List;

import com.codurance.solid.model.discount.DiscountRange;
import com.google.common.collect.ImmutableList;

public enum BookType {

	COOKING(ImmutableList.<DiscountRange>of()),
	FANTASY(ImmutableList.of(new DiscountRange(1, MAX_VALUE, 0.2))),
	IT(ImmutableList.of(new DiscountRange(2, MAX_VALUE, 0.3), new DiscountRange(0, 2, 0.1))), //
	TRAVEL(ImmutableList.of(new DiscountRange(3, MAX_VALUE, 0.4)));

	private List<DiscountRange> discountRanges;

	private BookType(List<DiscountRange> discountRanges) {
		this.discountRanges = discountRanges;
	}

	public List<DiscountRange> discount() {
		return discountRanges;
	}

}
