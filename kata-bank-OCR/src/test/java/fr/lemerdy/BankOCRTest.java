package fr.lemerdy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BankOCRTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void should_parse_an_entry() {
		Entry parsedInput = BankOCR.entry("" //
				+ "    _  _     _  _  _  _  _ \n" //
				+ "  | _| _||_||_ |_   ||_||_|\n" //
				+ "  ||_  _|  | _||_|  ||_| _|\n" //
				+ "                           ");
		assertThat(parsedInput.input()).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@Test
	public void an_entry_with_27_character_but_2_lines_is_invalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(containsString("Expecting 4 lines for an entry"));
		BankOCR.entry("" //
				+ "                           \n" //
				+ "                           ");
	}

	@Test
	public void an_entry_with_4_lines_but_26_characters_is_invalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(containsString("Expecting 27 characters per line for an entry"));
		BankOCR.entry("" //
				+ "                          \n" //
				+ " \n" //
				+ " \n" //
				+ " ");
	}
	
	@Test
	public void should_create_an_entry() throws Exception {
		Entry entry = BankOCR.entry("" //
				+ "    _  _     _  _  _  _  _ \n" //
				+ "  | _| _||_||_ |_   ||_||_|\n" //
				+ "  ||_  _|  | _||_|  ||_| _|\n" //
				+ "                           ");
		List<Integer> account = entry.input();
		assertThat(account).containsExactly(1,2,3,4,5,6,7,8,9);
		
	}
}
