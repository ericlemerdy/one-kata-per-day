import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class PokerHandComparatorTest {

    @Test
    public void should_win_with_high_card() {
        PokerHandComparator pokerHand = new PokerHandComparator(Hand.card(Value._2, Suit.heart)
                .card(Value._3, Suit.diamond).card(Value._5, Suit.spades).card(Value._9, Suit.clubs)
                .card(Value.King, Suit.diamond).player("Black"), Hand.card(Value._2, Suit.clubs)
                .card(Value._3, Suit.heart).card(Value._4, Suit.spades).card(Value._8, Suit.clubs)
                .card(Value.Ace, Suit.heart).player("White"));

        Winner winner = pokerHand.compare();
        assertThat(winner.getPlayerName()).isEqualTo("White");
        assertThat(winner.getReason()).isEqualTo("high card: Ace");
    }
}
