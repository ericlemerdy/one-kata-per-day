package name.lemerdy.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SuitTest {
	@Test
	public void with_a_valid_suit_char_should_create_suit() throws Exception {
		assertThat(Suit.withChar('♥')).isEqualTo(Suit.heart);
		assertThat(Suit.withChar('♦')).isEqualTo(Suit.diamond);
		assertThat(Suit.withChar('♠')).isEqualTo(Suit.spade);
		assertThat(Suit.withChar('♣')).isEqualTo(Suit.club);
	}

	@Test(expected = IllegalArgumentException.class)
	public void with_an_invalid_suit_should_not_create_suit() throws Exception {
		Suit.withChar('f');
	}

	@Test
	public void should_list_char_values() throws Exception {
		assertThat(Suit.charValues()).containsExactly('♥', '♦', '♠', '♣');
	}
}
