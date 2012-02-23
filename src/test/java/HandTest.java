import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class HandTest {

    @Test
    public void should_create_a_sorted_hand() {
        Hand hand = Hand.card(Value.Ace, Suit.heart).card(Value._2, Suit.clubs).card(Value._2, Suit.clubs)
                .card(Value._2, Suit.clubs).card(Value._2, Suit.clubs).player("Junit");
        List<Card> cards = hand.getCards();

        assertThat(cards).hasSize(5);
        assertThat(cards).onProperty("value").containsExactly(Value._2, Value._2, Value._2, Value._2, Value.Ace);
        assertThat(cards).onProperty("suit")
                .containsExactly(Suit.clubs, Suit.clubs, Suit.clubs, Suit.clubs, Suit.heart);
    }

    @Test
    public void with_a_straight_flush() {
        Hand hand = Hand.card(Value._7, Suit.diamond).card(Value._8, Suit.diamond).card(Value._9, Suit.diamond)
                .card(Value._10, Suit.diamond).card(Value.Jack, Suit.diamond).player("junit");

        assertThat(hand.hasStraightFlush_plainJava()).isTrue();
        // assertThat(hand.getStraightFlush()).isEqualTo(Value.Jack);
    }

}
