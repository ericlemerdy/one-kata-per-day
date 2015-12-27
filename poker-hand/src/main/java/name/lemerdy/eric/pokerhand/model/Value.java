package name.lemerdy.eric.pokerhand.model;

import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.Lists.transform;

import java.util.List;

import com.google.common.base.Function;

public enum Value {

	_2("2"), _3("3"), _4("4"), _5("5"), _6("6"), _7("7"), _8("8"), _9("9"), _10("10"), Jack("J"), Queen("Q"), King("K"), Ace("A");

	private final String stringValue;

	Value(String stringValue) {
		this.stringValue = stringValue;
	}

	public static Value withString(String value) {
		final List<String> values = Value.stringValues();
		if (values.contains(value)) {
			for (Value possibleValue : Value.values()) {
				if (value.equals(possibleValue.toString())) {
					return possibleValue;
				}
			}
		}
		throw new IllegalArgumentException();
	}

	protected static List<String> stringValues() {
		return transform(copyOf(Value.values()), new Function<Value, String>() {
			@Override
			public String apply(Value value) {
				return value.stringValue;
			}
		});
	}

	@Override
	public String toString() {
		return stringValue;
	}

}
