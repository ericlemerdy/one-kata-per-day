import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CardTest {

    @Test
    public void with_the_same_suit_two_card_should_be_ordered_by_value() throws Exception {
        Card fiveHeart = new Card(Value._5, Suit.heart);
        Card sixHeart = new Card(Value._6, Suit.heart);

        assertThat(fiveHeart.compareTo(sixHeart)).isLessThan(0);
    }

    @Test
    public void with_the_same_value_two_card_should_be_ordered_by_suit() throws Exception {
        Card fiveHeart = new Card(Value._5, Suit.heart);
        Card fiveDiamond = new Card(Value._5, Suit.diamond);

        assertThat(fiveHeart.compareTo(fiveDiamond)).isLessThan(0);
    }

    @Test
    public void with_different_values_and_suit_two_card_should_be_ordered_by_value_then_by_suit() throws Exception {
        Card fourDiamond = new Card(Value._4, Suit.diamond);
        Card fiveHeart = new Card(Value._5, Suit.heart);

        assertThat(fourDiamond.compareTo(fiveHeart)).isLessThan(0);
    }
}
