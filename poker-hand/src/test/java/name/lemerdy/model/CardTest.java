package name.lemerdy.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CardTest {
	@Test
	public void should_create_card_with_value_and_suit_as_characters() throws Exception {
		Card card = new Card("2♠");

		assertThat(card).isEqualTo(new Card("2♠"));
	}

	@Test
	public void with_the_same_suit_two_card_should_be_ordered_by_value() throws Exception {
		Card fiveHeart = new Card("5♥");
		Card sixHeart = new Card("6♥");

		assertThat(fiveHeart.compareTo(sixHeart)).isLessThan(0);
	}

	@Test
	public void with_the_same_value_two_card_should_be_ordered_by_suit() throws Exception {
		Card fiveHeart = new Card("5♥");
		Card fiveDiamond = new Card("5♦");

		assertThat(fiveHeart.compareTo(fiveDiamond)).isLessThan(0);
	}

	@Test
	public void with_different_values_and_suit_two_card_should_be_ordered_by_value_then_by_suit() throws Exception {
		Card fourDiamond = new Card("4♦");
		Card fiveHeart = new Card("5♥");

		assertThat(fourDiamond.compareTo(fiveHeart)).isLessThan(0);
	}
}
