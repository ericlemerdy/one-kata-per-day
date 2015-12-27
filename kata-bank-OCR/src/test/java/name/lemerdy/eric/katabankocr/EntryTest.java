package name.lemerdy.eric.katabankocr;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class EntryTest {

	@Test
	public void should_parse_2_numbers() {
		List<Integer> parsedInput = Entry.parse( //
				"      ", //
				"  |  |", //
				"  |  |");
		assertThat(parsedInput).containsExactly(1, 1);
	
	}

	@Test
	public void should_parse_3_numbers() {
		List<Integer> parsedInput = Entry.parse( //
				"         ", //
				"  |  |  |", //
				"  |  |  |");
		assertThat(parsedInput).containsExactly(1, 1, 1);
	
	}

	@Test
	public void should_parse_the_number_zero() {
		int parsedInput = Entry.parseNumber( //
				" _ ", //
				"| |", //
				"|_|");
		assertThat(parsedInput).isEqualTo(0);
	}

	@Test
	public void should_parse_the_number_one() {
		int parsedInput = Entry.parseNumber( //
				"   ", //
				"  |", //
				"  |");
		assertThat(parsedInput).isEqualTo(1);
	}

	@Test
	public void should_parse_the_number_two() {
		int parsedInput = Entry.parseNumber( //
				" _ ", //
				" _|", //
				"|_ ");
		assertThat(parsedInput).isEqualTo(2);
	}

	@Test
	public void should_parse_the_number_three() {
		int parsedInput = Entry.parseNumber( //
				" _ ", //
				" _|", //
				" _|");
		assertThat(parsedInput).isEqualTo(3);
	}

	@Test
	public void should_parse_the_number_four() {
		int parsedInput = Entry.parseNumber( //
				"   ", //
				"|_|", //
				"  |");
		assertThat(parsedInput).isEqualTo(4);
	}

	@Test
	public void should_parse_the_number_five() {
		int parsedInput = Entry.parseNumber( //
				" _ ", //
				"|_ ", //
				" _|");
		assertThat(parsedInput).isEqualTo(5);
	}

	@Test
	public void should_parse_the_number_six() {
		int parsedInput = Entry.parseNumber( //
				" _ ", //
				"|_ ", //
				"|_|");
		assertThat(parsedInput).isEqualTo(6);
	}

	@Test
	public void should_parse_the_number_seven() {
		int parsedInput = Entry.parseNumber( //
				" _ ", //
				"  |", //
				"  |");
		assertThat(parsedInput).isEqualTo(7);
	}

	@Test
	public void should_parse_the_number_eight() {
		int parsedInput = Entry.parseNumber( //
				" _ ", //
				"|_|", //
				"|_|");
		assertThat(parsedInput).isEqualTo(8);
	}

	@Test
	public void should_parse_the_number_nine() {
		int parsedInput = Entry.parseNumber( //
				" _ ", //
				"|_|", //
				" _|");
		assertThat(parsedInput).isEqualTo(9);
	}

}
