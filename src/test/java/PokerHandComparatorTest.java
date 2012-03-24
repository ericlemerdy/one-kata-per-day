import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class PokerHandComparatorTest {

    @Test
    public void should_win_with_high_card() {
        Deck deck = new Deck(PokerHand.hand().addCard(null, null) //
                .addCard(Value._3, Suit.diamond) //
                .addCard(Value._5, Suit.spades) //
                .addCard(Value._9, Suit.clubs) //
                .addCard(Value.King, Suit.diamond).player(), //
                PokerHand.hand().addCard(Value._2, Suit.heart) //
                        .addCard(Value._3, Suit.heart) //
                        .addCard(Value._4, Suit.spades) //
                        .addCard(Value._8, Suit.clubs) //
                        .addCard(Value.Ace, Suit.heart).player());
        PokerHandComparator pokerHand = new PokerHandComparator(deck);

        Winner winner = pokerHand.compare();
        assertThat(winner.getPlayerName()).isEqualTo("White");
        assertThat(winner.getReason()).isEqualTo("high card: Ace");
    }
}
