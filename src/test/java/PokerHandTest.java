import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class PokerHandTest {

    @Test
    public void should_create_a_sorted_hand() {
        // Hand.card().two().of().club()

        PokerHand hand = PokerHand.hand().addCard(Value.Ace, Suit.heart) //
                .addCard(Value._2, Suit.clubs) //
                .addCard(Value._2, Suit.clubs) //
                .addCard(Value._2, Suit.clubs) //
                .addCard(Value._2, Suit.clubs).player("Junit");
        List<Card> cards = hand.getCards();

        assertThat(cards).hasSize(5);
        assertThat(cards).onProperty("value").contains(Value._2, Value._2, Value._2, Value._2, Value.Ace);
        assertThat(cards).onProperty("suit").contains(Suit.heart, Suit.clubs, Suit.clubs, Suit.clubs, Suit.heart);
    }

    @Test
    public void with_a_straight_flush() {
        PokerHand hand = PokerHand.hand().addCard(Value._7, Suit.diamond) //
                .addCard(Value._8, Suit.diamond) //
                .addCard(Value._9, Suit.diamond) //
                .addCard(Value._10, Suit.diamond) //
                .addCard(Value.Jack, Suit.diamond).player("junit");

        assertThat(hand.hasStraightFlush_plainJava()).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_create_a_hand_with_less_than_5_cards() {
        PokerHand.hand().addCard(Value._10, Suit.clubs).player("junit");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_create_a_hand_with_more_than_5_cards() {
        PokerHand.hand().addCard(Value._10, Suit.clubs) //
                .addCard(Value._10, Suit.clubs)//
                .addCard(Value._10, Suit.clubs)//
                .addCard(Value._10, Suit.clubs)//
                .addCard(Value._10, Suit.clubs)//
                .addCard(Value._10, Suit.clubs)//
                .player("junit");
    }

}
