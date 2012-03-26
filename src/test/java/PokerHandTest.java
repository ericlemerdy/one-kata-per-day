import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PokerHandTest {

    @Test
    public void with_a_straight_flush() {
        Deck deck = new Deck();
        Deck.PokerHand hand = deck.black().addCard(Value._7, Suit.diamond)
                .addCard(Value._8, Suit.diamond)
                .addCard(Value._9, Suit.diamond)
                .addCard(Value._10, Suit.diamond)
                .addCard(Value.Jack, Suit.diamond).player();

        assertThat(hand.hasStraightFlush_plainJava()).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_create_a_hand_with_less_than_5_cards() {
        Deck deck = new Deck();
        deck.black().addCard(Value._10, Suit.club).player();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_create_a_hand_with_more_than_5_cards() {
        Deck deck = new Deck();
        deck.black().addCard(Value._10, Suit.club)
                .addCard(Value._9, Suit.club)//
                .addCard(Value._8, Suit.club)//
                .addCard(Value._7, Suit.club)//
                .addCard(Value._6, Suit.club)//
                .addCard(Value._5, Suit.club)//
                .player();
    }


    @Test(expected = IllegalArgumentException.class)
    public void with_one_hand_should_not_distribute_the_same_card_twice() throws Exception {
        Deck deck = new Deck();
        deck.black().addCard(Value.Ace, Suit.club).addCard(Value.Ace, Suit.club);
    }
}
