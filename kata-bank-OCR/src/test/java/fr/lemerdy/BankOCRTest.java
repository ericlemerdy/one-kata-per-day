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
	public void should_parse_the_number_zero() {
		int parsedInput = BankOCR.parseNumber( //
				" _ ", //
				"| |", //
				"|_|");
		assertThat(parsedInput).isEqualTo(0);
	}

	@Test
	public void should_parse_the_number_one() {
		int parsedInput = BankOCR.parseNumber( //
				"   ", //
				"  |", //
				"  |");
		assertThat(parsedInput).isEqualTo(1);
	}

	@Test
	public void should_parse_the_number_two() {
		int parsedInput = BankOCR.parseNumber( //
				" _ ", //
				" _|", //
				"|_ ");
		assertThat(parsedInput).isEqualTo(2);
	}

	@Test
	public void should_parse_the_number_three() {
		int parsedInput = BankOCR.parseNumber( //
				" _ ", //
				" _|", //
				" _|");
		assertThat(parsedInput).isEqualTo(3);
	}

	@Test
	public void should_parse_the_number_four() {
		int parsedInput = BankOCR.parseNumber( //
				"   ", //
				"|_|", //
				"  |");
		assertThat(parsedInput).isEqualTo(4);
	}

	@Test
	public void should_parse_the_number_five() {
		int parsedInput = BankOCR.parseNumber( //
				" _ ", //
				"|_ ", //
				" _|");
		assertThat(parsedInput).isEqualTo(5);
	}

	@Test
	public void should_parse_the_number_six() {
		int parsedInput = BankOCR.parseNumber( //
				" _ ", //
				"|_ ", //
				"|_|");
		assertThat(parsedInput).isEqualTo(6);
	}

	@Test
	public void should_parse_the_number_seven() {
		int parsedInput = BankOCR.parseNumber( //
				" _ ", //
				"  |", //
				"  |");
		assertThat(parsedInput).isEqualTo(7);
	}

	@Test
	public void should_parse_the_number_eight() {
		int parsedInput = BankOCR.parseNumber( //
				" _ ", //
				"|_|", //
				"|_|");
		assertThat(parsedInput).isEqualTo(8);
	}

	@Test
	public void should_parse_the_number_nine() {
		int parsedInput = BankOCR.parseNumber( //
				" _ ", //
				"|_|", //
				" _|");
		assertThat(parsedInput).isEqualTo(9);
	}

	@Test
	public void should_parse_2_numbers() {
		List<Integer> parsedInput = BankOCR.parse( //
				"      ", //
				"  |  |", //
				"  |  |");
		assertThat(parsedInput).containsExactly(1, 1);

	}

	@Test
	public void should_parse_3_numbers() {
		List<Integer> parsedInput = BankOCR.parse( //
				"         ", //
				"  |  |  |", //
				"  |  |  |");
		assertThat(parsedInput).containsExactly(1, 1, 1);

	}

	@Test
	public void should_parse_an_entry() {
		List<Integer> parsedInput = BankOCR.forEntry("" //
				+ "    _  _     _  _  _  _  _ \n" //
				+ "  | _| _||_||_ |_   ||_||_|\n" //
				+ "  ||_  _|  | _||_|  ||_| _|\n" //
				+ "                           ");
		assertThat(parsedInput).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@Test
	public void an_entry_with_27_character_but_2_lines_is_invalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(containsString("Expecting 4 lines for an entry"));
		BankOCR.forEntry("" //
				+ "                           \n" //
				+ "                           ");
	}

	@Test
	public void an_entry_with_4_lines_but_26_characters_is_invalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(containsString("Expecting 27 characters per line for an entry"));
		BankOCR.forEntry("" //
				+ "                          \n" //
				+ " \n" //
				+ " \n" //
				+ " ");
	}
}
