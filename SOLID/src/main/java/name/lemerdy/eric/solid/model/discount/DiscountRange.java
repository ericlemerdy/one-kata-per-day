package name.lemerdy.eric.solid.model.discount;

public class DiscountRange {

	public final double min;
	public final double max;
	public final double discount;

	public DiscountRange(int min, double max, double discount) {
		this.min = min;
		this.max = max;
		this.discount = discount;
	}

}
