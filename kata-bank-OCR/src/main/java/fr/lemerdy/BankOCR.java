package fr.lemerdy;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;
import java.util.List;

public class BankOCR {

	public static List<Integer> forEntry(String input) {
		String[] split = input.split("\n");
		checkArgument(split.length == 4, "Expecting 4 lines for an entry");
		newArrayList(split).stream().forEach(
				s -> checkArgument(s.length() == 27,
						"Expecting 27 characters per line for an entry"));
		return BankOCR.parse(split[0], split[1], split[2]);
	}

	public static List<Integer> parse(String line0, String line1, String line2) {
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < line0.length(); i += 3) {
			output.add(parseNumber(line0.substring(i), line1.substring(i),
					line2.substring(i)));
		}
		return output;
	}

	public static int parseNumber(String line0, String line1, String line2) {
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

}
