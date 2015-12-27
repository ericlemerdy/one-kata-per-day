package name.lemerdy.eric.katabankocr;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Lists.newArrayList;

public class BankOCR {

	public static Entry entry(String input) {
		String[] split = input.split("\n");
		checkArgument(split.length == 4, "Expecting 4 lines for an entry");
		newArrayList(split).stream().forEach(
				s -> checkArgument(s.length() == 27,
						"Expecting 27 characters per line for an entry"));
		return new Entry(Entry.parse(split[0], split[1], split[2]));
	}

}
