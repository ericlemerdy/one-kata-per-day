package fr.lemerdy;

import java.util.ArrayList;
import java.util.List;

public class BankOCR {

	public static List<Integer> parse(String input) {
		String[] split = input.split("\n");
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < split[0].length(); i+=3) {
			output.add(parse(split[0].substring(i),
					split[1].substring(i), split[2].substring(i)));
		}
		return output;
	}

	public static int parse(String line0, String line1, String line2) {
		if (line1.charAt(0) != ' ') {
			return 4;
		}
		if (line0.charAt(1) == ' ') {
			return 1;
		}
		if (line2.charAt(2) == ' ') {
			return 2;
		}
		return 3;
	}

}
