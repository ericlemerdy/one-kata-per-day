import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class HandTest {

    @Test
    public void should_create_a_sorted_hand() {
        Hand hand = Hand.card(Value.Ace, Suit.heart).card(Value._2, Suit.clubs).card(Value._2, Suit.clubs)
                .card(Value._2, Suit.clubs).card(Value._2, Suit.clubs).player("Junit");

        assertThat(hand.getCards()).hasSize(5);
        assertCard(hand.getCards().get(0), Value._2, Suit.clubs);
        assertCard(hand.getCards().get(1), Value._2, Suit.clubs);
        assertCard(hand.getCards().get(2), Value._2, Suit.clubs);
        assertCard(hand.getCards().get(3), Value._2, Suit.clubs);
        assertCard(hand.getCards().get(4), Value.Ace, Suit.heart);
        assertThat(hand.getPlayerName()).isEqualTo("Junit");
    }

    private void assertCard(Card actual, Value expectedValue, Suit expectedSuit) {
        assertThat(actual.getValue()).isEqualTo(expectedValue);
        assertThat(actual.getSuit()).isEqualTo(expectedSuit);
    }

    @Test
    public void with_a_straight_flush() {
        Hand hand = Hand.card(Value._7, Suit.diamond).card(Value._8, Suit.diamond).card(Value._9, Suit.diamond)
                .card(Value._10, Suit.diamond).card(Value.Jack, Suit.diamond).player("junit");

        assertThat(hand.hasStraightFlush_plainJava()).isTrue();
        // assertThat(hand.getStraightFlush()).isEqualTo(Value.Jack);
    }
}
