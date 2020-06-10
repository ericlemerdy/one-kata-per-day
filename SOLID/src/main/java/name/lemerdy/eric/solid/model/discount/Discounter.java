package name.lemerdy.eric.solid.model.discount;

import java.util.List;

public class Discounter {

	private Discounter() {}

	public static double priceAfterDiscount(double numberOfBooks,
											double totalPrice, List<DiscountRange> discountRanges) {
		double booksDiscount = 1;

		for (DiscountRange discountRange : discountRanges) {
			if (discountRange.min < numberOfBooks
					&& numberOfBooks <= discountRange.max) {
				booksDiscount = 1 - discountRange.discount;
			}
		}

		totalPrice *= booksDiscount;

		return totalPrice;
	}

}
