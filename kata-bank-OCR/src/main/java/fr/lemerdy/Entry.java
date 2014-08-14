package fr.lemerdy;

import static com.google.common.collect.ImmutableList.copyOf;

import java.util.ArrayList;
import java.util.List;

import com.google.common.annotations.VisibleForTesting;

public class Entry {

	private List<Integer> accountNumber;

	public Entry(List<Integer> accountNumber) {
		this.accountNumber = copyOf(accountNumber);
	}

	public Account toAccount() {
		Integer number = this.accountNumber.stream().reduce(0, (i, j) -> j + i * 10);
		return new Account(number);
	}

	@VisibleForTesting
	protected List<Integer> input() {
		return accountNumber;
	}

	protected static int parseNumber(String line0, String line1, String line2) {
		if (line0.charAt(1) == ' ') {
			if (line1.charAt(0) == ' ') {
				return 1;
			} else {
				return 4;
			}
		} else {
			if (line1.charAt(0) == ' ') {
				if (line1.charAt(1) == ' ') {
					return 7;
				} else {
					if (line2.charAt(0) == ' ') {
						return 3;
					} else {
						return 2;
					}
				}
			} else {
				if (line1.charAt(2) == ' ') {
					if (line2.charAt(0) == ' ') {
						return 5;
					} else {
						return 6;
					}
				} else {
					if (line2.charAt(0) == ' ') {
						return 9;
					} else {
						if (line1.charAt(1) == ' ') {
							return 0;
						} else {
							return 8;
						}
					}
				}
			}
		}
	}

	protected static List<Integer> parse(String line0, String line1, String line2) {
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < line0.length(); i += 3) {
			output.add(Entry.parseNumber(line0.substring(i), line1.substring(i),
					line2.substring(i)));
		}
		return output;
	}

}
