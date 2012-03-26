import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PokerHandComparatorTest {

    @Test
    public void should_win_with_high_card() {
        Deck deck = new Deck();
        deck.black().addCard(Value._2, Suit.heart)
                .addCard(Value._3, Suit.diamond)
                .addCard(Value._5, Suit.spade)
                .addCard(Value._9, Suit.club)
                .addCard(Value.King, Suit.diamond).player();
        deck.white().addCard(Value._2, Suit.club)
                .addCard(Value._3, Suit.heart)
                .addCard(Value._4, Suit.spade)
                .addCard(Value._8, Suit.club)
                .addCard(Value.Ace, Suit.heart).player();
        PokerHandComparator pokerHand = new PokerHandComparator(deck);

        Winner winner = pokerHand.compare();
        assertThat(winner.getPlayerName()).isEqualTo("White");
        assertThat(winner.getReason()).isEqualTo("high card: Ace");
    }
}
