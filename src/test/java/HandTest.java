import static org.fest.assertions.Assertions.assertThat;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class HandTest {

    @Test
    public void should_create_a_sorted_hand() {
        Hand hand = Hand.card(Value.Ace, Suit.heart).card(Value._2, Suit.clubs).card(Value._2, Suit.clubs)
                .card(Value._2, Suit.clubs).card(Value._2, Suit.clubs).player("Junit");

        Assertions.assertThat(hand.getCards()).hasSize(5);

        Assertions.assertThat(hand.getCards().get(0).getValue()).isEqualTo(Value._2);
        Assertions.assertThat(hand.getCards().get(0).getSuit()).isEqualTo(Suit.clubs);

        Assertions.assertThat(hand.getCards().get(1).getValue()).isEqualTo(Value._2);
        Assertions.assertThat(hand.getCards().get(1).getSuit()).isEqualTo(Suit.clubs);

        Assertions.assertThat(hand.getCards().get(2).getValue()).isEqualTo(Value._2);
        Assertions.assertThat(hand.getCards().get(2).getSuit()).isEqualTo(Suit.clubs);

        Assertions.assertThat(hand.getCards().get(3).getValue()).isEqualTo(Value._2);
        Assertions.assertThat(hand.getCards().get(3).getSuit()).isEqualTo(Suit.clubs);

        Assertions.assertThat(hand.getCards().get(4).getValue()).isEqualTo(Value.Ace);
        Assertions.assertThat(hand.getCards().get(4).getSuit()).isEqualTo(Suit.heart);

        Assertions.assertThat(hand.getPlayerName()).isEqualTo("Junit");
    }

    @Test
    public void with_a_straight_flush() {
        Hand hand = Hand.card(Value._7, Suit.diamond).card(Value._8, Suit.diamond).card(Value._9, Suit.diamond)
                .card(Value._10, Suit.diamond).card(Value.Jack, Suit.diamond).player("junit");

        assertThat(hand.hasStraightFlush_plainJava()).isTrue();
        // assertThat(hand.getStraightFlush()).isEqualTo(Value.Jack);
    }
}
