import org.junit.Test;

public class DeckTest {

    @Test(expected = IllegalArgumentException.class)
    public void with_two_hands_should_not_distribute_the_same_card_twice() throws Exception {
        PokerHand white = PokerHand.hand().addCard(Value._2, Suit.clubs).//
                addCard(Value._3, Suit.clubs).addCard(Value._4, Suit.clubs).addCard(Value._5, Suit.clubs).addCard(Value._6, Suit.clubs).player();
        PokerHand black = PokerHand.hand().addCard(Value._2, Suit.clubs).//
                addCard(Value._3, Suit.clubs).addCard(Value._4, Suit.clubs).addCard(Value._5, Suit.clubs).addCard(Value._6, Suit.clubs).player();
        Deck deck = new Deck(black, white);
    }
}
