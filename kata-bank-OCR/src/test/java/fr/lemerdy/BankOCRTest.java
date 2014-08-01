package fr.lemerdy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class BankOCRTest {
	@Test
	public void should_parse_the_number_one() {
		List<Integer> parsedInput = BankOCR.parse("" //
				+ "   \n" //
				+ "  |\n" //
				+ "  |");
		assertThat(parsedInput).containsExactly(1);
	}

	@Test
	public void should_parse_the_number_two() {
		List<Integer> parsedInput = BankOCR.parse("" //
				+ " _ \n" //
				+ " _|\n" //
				+ "|_ ");
		assertThat(parsedInput).containsExactly(2);
	}

	@Test
	public void should_parse_three() {
		List<Integer> parsedInput = BankOCR.parse("" //
				+ " _ \n" //
				+ " _|\n" //
				+ " _|");
		assertThat(parsedInput).containsExactly(3);
	}

	@Test
	public void should_parse_four() {
		List<Integer> parsedInput = BankOCR.parse("" //
				+ "   \n" //
				+ "|_|\n" //
				+ "  |");
		assertThat(parsedInput).containsExactly(4);
	}

	@Test
	public void should_parse_2_numbers() {
		List<Integer> parsedInput = BankOCR.parse("" //
				+ "      \n" //
				+ "  |  |\n" //
				+ "  |  |");
		assertThat(parsedInput).containsExactly(1, 1);

	}

	@Test
	public void should_parse_3_numbers() {
		List<Integer> parsedInput = BankOCR.parse("" //
				+ "         \n" //
				+ "  |  |  |\n" //
				+ "  |  |  |");
		assertThat(parsedInput).containsExactly(1, 1, 1);

	}
}
