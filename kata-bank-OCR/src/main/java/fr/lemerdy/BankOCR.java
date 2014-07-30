package fr.lemerdy;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class BankOCR {

	public static List<Integer> parse(String input) {
		String[] split = input.split("\n");
		List<Integer> output = new ArrayList<Integer>();
		output.addAll(parse(split[0].substring(0), split[1].substring(0),
				split[2].substring(0)));
		if (split[0].length() > 3) {
			output.addAll(parse(split[0].substring(3), split[1].substring(3),
					split[2].substring(3)));
		}
		if (split[0].length() > 6) {
			output.addAll(parse(split[0].substring(6), split[1].substring(6),
					split[2].substring(6)));
		}
		return output;
	}

	public static List<Integer> parse(String line0, String line1, String line2) {
		if (line0.charAt(1) == ' ') {
			return asList(1);
		}
		if (line2.charAt(2) == ' ') {
			return asList(2);
		}
		return asList(3);
	}

}
